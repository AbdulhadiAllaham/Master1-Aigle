<?php
	session_start();
	
	include("includes/infoConnexion.php");

	$conn = oci_connect($login, $mdp, $chaine_hote);

	if (!$conn)
	{
		$e = oci_error();   // For oci_connect errors pass no handle
		echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
	}
	else
	{
		$nomConcept = htmlentities(strtolower($_POST['concept']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
		$dateCreation = date("d-m-Y");
		$nbConsult = 0;
		$def = htmlentities($_POST['defVedette'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
		$def = str_replace ("'", "''", $def);
		$def = str_replace ("’", "''", $def);
		$contrib = $_SESSION['email'];
		$flagOK = true;
		// Insertion du concept
		$sql = "INSERT INTO Concept VALUES ('$nomConcept', '$dateCreation', $nbConsult, '', (select ref(p) from Contributeur p where email='$contrib'))";

		$stmt = oci_parse($conn,$sql);
		$r = oci_execute($stmt);
		if (!$r)
		{
			$flagOK = false;
		}
		
		// S'il y a un terme de généralisation
		$gen = htmlentities(strtolower($_POST['generalisation']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
		$gen1 = htmlentities(strtolower($_POST['generalisation']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
		$vedette1 = htmlentities(strtolower($_POST['vedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
		if ($gen != "NULL")
		{
			$gen = "(SELECT REF(P) FROM DescripteurVedette P WHERE P.libelle='$gen')";
		}
		
		// Insertion du terme vedette
		$libelleTV = htmlentities(strtolower($_POST['vedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
		$sql = "INSERT INTO DescripteurVedette VALUES ('$libelleTV', '$dateCreation', $nbConsult, '$def', (select ref(p) from Contributeur p where email='$contrib'), '$nomConcept', $gen, NULL, NULL)";
		
		$stmt = oci_parse($conn,$sql);
		$r = oci_execute($stmt);

		$sql111 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where (d.libelle)='$gen1'";
		//echo $sql111;
		$stmt111 = oci_parse($conn,$sql111);
		oci_define_by_name($stmt111, 'LIBELLE', $libelleSynTest);
		oci_execute($stmt111);
		oci_fetch($stmt111);


		if ($libelleSynTest == '')
		{
			$sql411 = "UPDATE DescripteurVedette SET descripteur_spec = (ensemble_specialisation(ens_descr('$vedette1', '$dateCreation', 0, '', (select ref(p) from Contributeur p where email='$contrib')))) where libelle = '$gen1'";
			//echo $sql411;
			$stmt411 = oci_parse($conn, $sql411);
			oci_execute($stmt411);
		}
		else if ($libelleSynTest != $gen1)
		{
			$sql311 = "INSERT INTO TABLE (select descripteur_spec from DescripteurVedette where libelle='$gen1') VALUES (ens_descr('$vedette1', '$dateCreation', 0, '',(select ref(p) from Contributeur p where p.email='$contrib')))";
			//echo $sql311;
			$stmt311 = oci_parse($conn,$sql311);
			oci_execute($stmt311);
		}

		
		// Traitement synonymes
		// Nombre de champs dans le formulaire avant l'ajout de champs avec le bouton "Ajouter un synonyme" (boutons "Envoyer" et "Annuler" inclus)
		$i = 6;
		if (isset($_POST['terme_synonyme1']))
		{
			// Pour la 1ère insertion, il faut utiliser UPDATE
			$libelleSyn = htmlentities(strtolower($_POST['terme_synonyme1']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$sql11 = "UPDATE DescripteurVedette set ensemble_synonymes = (ensemble_synonyme(DescripteurSynonyme('$libelleSyn', '$dateCreation', $nbConsult, '$def',(select ref(p) from Contributeur p where p.email='$contrib')))) where LOWER(libelle) = '$libelleTV'";
			$stmt11 = oci_parse($conn,$sql11);
			$r = oci_execute($stmt11);
			if (!$r) $flagOK = false;
		
			$i++;
			$cpt = 2;
			//echo "taille _POST : " . sizeof($_POST);
			//echo "i : $i";
			// Insertion des synonymes suivants
			while ($i <= sizeof($_POST) && $libelleTV != '')
			{
				
				$libelleSyn = htmlentities(strtolower($_POST['terme_synonyme'.$cpt]), ENT_QUOTES | ENT_IGNORE, "UTF-8");
				$sql11 = "INSERT INTO TABLE (select ensemble_synonymes from DescripteurVedette where LOWER(libelle)='$libelleTV') VALUES (DescripteurSynonyme('$libelleSyn', '$dateCreation', $nbConsult, '$def',(select ref(p) from Contributeur p where p.email='$contrib')))";
				$stmt11 = oci_parse($conn, $sql11);
				$r = oci_execute($stmt11);
				if (!$r) $flagOK = false;
				
				$i++;
				$cpt++;
			}
		}

		// Insertion terme de spécialisation
		if(isset($_POST['termes']))
		{
			$vedette = htmlentities(strtolower($_POST['vedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
 
			foreach($_POST['termes'] as $chkbx)
			{
				$chkbx = htmlentities($chkbx, ENT_QUOTES | ENT_IGNORE, "UTF-8");
				// Récupération des spécialisations du terme
				$sql2 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where (d.libelle)='$vedette'";
				$stmt2 = oci_parse($conn, $sql2);
				oci_define_by_name($stmt2, 'LIBELLE', $libellespecialisation);
				$r2 = oci_execute($stmt2);
				oci_fetch($stmt2);
				
				//echo "lib $libellespecialisation";
				$verifDoublure = true;
				while(oci_fetch($stmt2))
				{
					if(htmlentities($libellespecialisation, ENT_QUOTES | ENT_IGNORE, "UTF-8") == $chkbx )
					{
						$verifDoublure = false;
						echo "doublure";
					}					
				}

				$sql211 =" update DescripteurVedette set descripteur_gen = (select ref(p) from DescripteurVedette p where p.libelle = '$vedette') where libelle = '$chkbx'";
				$stmt211 = oci_parse($conn, $sql211);
				oci_execute($stmt211);

				// Récupération des spécialisations du terme de généralisation
				$sql212 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where d.libelle='$gen1'";
				//echo $sql212;
				$stmt212 = oci_parse($conn, $sql212);
				oci_define_by_name($stmt212, 'LIBELLE', $libellegeneralisation);
				oci_execute($stmt212);
				//oci_fetch($stmt212);
				
				while(oci_fetch($stmt212))
				{
					//echo "spec $libellegeneralisation";
					//echo "gen1 $gen1 ";
					if ($libellegeneralisation == $chkbx)
					{
						$sql213 = "delete from table(select d.descripteur_spec from DescripteurVedette d where d.libelle = '$gen1') t where t.libelle = '$chkbx'";
						//echo $sql213;
				
						$stmt213 = oci_parse($conn, $sql213);
						oci_execute($stmt213);
					}
				}

				if ($libellespecialisation == '')
				{
					//echo "libelle spec $libellespecialisation";
					// Comme il s'agit d'une 1ere insertion, on utilise UPDATE
					$sql4 = "UPDATE DescripteurVedette SET descripteur_spec = (ensemble_specialisation(ens_descr('$chkbx', '$dateCreation', 0, '', (select ref(p) from Contributeur p where email='$contrib')))) where libelle = '$vedette'";
					//echo $sql4;
					$stmt4 = oci_parse($conn, $sql4);
					$r = oci_execute($stmt4);
					if (!$r) $flagOK = false;
				}
				else if ($verifDoublure != false)
				{
					//echo $chkbx;
					$sql3 = "INSERT INTO TABLE (select descripteur_spec from DescripteurVedette where libelle='$vedette') VALUES (ens_descr('$chkbx', '$dateCreation', 0, '',(select ref(p) from Contributeur p where p.email='$contrib')))";
					//echo $sql3;
					$stmt3 = oci_parse($conn,$sql3);
					$r3 = oci_execute($stmt3);
					if (!$r3) $flagOK = false;
				}
 
			}
		}




	}
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Ajout d'un concept</title>
		
		<?php include("includes/meta.php"); ?>
		
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
		<script type="text/javascript" src="javascript.js"></script>
		
	</head>
	<body>
	<div id="bandeau"><a href="index.php"><img src="images/titreBanniere.png" /></a></div>
	<div id="general">
		<div id="blocRecherche">
			<?php include("includes/blocRecherche.php"); ?>
		</div>
		<div id="blocLog">
			<?php include("includes/blocLog.php"); ?>
		</div>
		<div id="contenu">
			<h1>Ajouter un concept</h1>
			<?php
				if ($flagOK)
				{
					echo '<p>Ajout réussi !</p>';
					echo '<p><a href="listeTermes.php">Liste des termes</a></p>';
				}
				else
				{
					echo '<p>Une erreur est survenue.</p>';
					echo '<p><a href="ajoutConcept.php">Retour</a></p>';
				}
			?>
		</div>
	</div>
	</body>
</html>

