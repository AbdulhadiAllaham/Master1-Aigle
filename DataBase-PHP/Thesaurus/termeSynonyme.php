<?php
	session_start();
	
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Consultation</title>
		
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
			<?php
			
			include("includes/infoConnexion.php");

			$conn = oci_connect($login, $mdp, $chaine_hote);

			if (!$conn)
			{
				$e = oci_error();   // For oci_connect errors pass no handle

				echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
			}
			else
			{			
				// Si l'utilisateur a cliqué sur un terme
				if (isset($_GET['nomTerme']))
				{
					$recherche = htmlentities(strtolower($_GET["nom"]), ENT_QUOTES | ENT_IGNORE, "UTF-8");
				}
				// Si c'est une recherche
				else
				{
					$recherche = htmlentities(strtolower($_GET["nom"]), ENT_QUOTES | ENT_IGNORE, "UTF-8");
				}
					$nomTerme = htmlentities(strtolower($_GET["nomTerme"]), ENT_QUOTES | ENT_IGNORE, "UTF-8");
				// Champs du terme que l'on veut afficher
				$sql = "select libelle, nomConcept, dateCreation, nombreConsultations, definition from DescripteurVedette where libelle='".$recherche."'";
				// Récupération de la date de création du synonyme
				$sql11 = "select t.dateCreation from DescripteurVedette d ,table (d.ensemble_synonymes) t where d.libelle='$recherche' and t.libelle='$nomTerme'";
				// Récupération du descripteur de spécialisation
				$sql2 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where d.libelle='$recherche'";
				//echo $sql2;
				// Récupération des synonymes
				$sql3 = "select t.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where d.libelle='".$recherche."' order by t.libelle";
				// Récupération de la définition
				$sql31 = "select t.definition from DescripteurVedette d ,table (d.ensemble_synonymes) t where d.libelle='$recherche' and t.libelle='$nomTerme'";
				// Récupération du contributeur
				$sql4 = "select (t.contributeur_descripteur).email as email from DescripteurVedette d, table (d.ensemble_synonymes) t where d.libelle='$recherche' and t.libelle='$nomTerme'";
				// Récupération du descripteur de généralisation
				$sql41 = "select (descripteur_gen).libelle from DescripteurVedette where LOWER(libelle)='".$recherche."'";
				// Augmentation du nombre de consultations
				$sql5 = "UPDATE DescripteurVedette set nombreConsultations = (nombreConsultations + 1) where libelle='".$recherche."'";


				$stmt = oci_parse($conn,$sql);
				$stmt11 = oci_parse($conn,$sql11);
				$stmt2 = oci_parse($conn,$sql2);
				$stmt3 = oci_parse($conn,$sql3);
				$stmt31 = oci_parse($conn,$sql31);
				$stmt4 = oci_parse($conn,$sql4);
				$stmt41 = oci_parse($conn,$sql41);
				$stmt5 = oci_parse($conn,$sql5);

				oci_define_by_name($stmt, 'NOMCONCEPT', $nomConcept);
				oci_define_by_name($stmt11, 'DATECREATION', $dateCreation);
				oci_define_by_name($stmt, 'NOMBRECONSULTATIONS', $nbConsultations);
				oci_define_by_name($stmt, 'DEFINITION', $definition);
				$libelle = $nomTerme;
				oci_define_by_name($stmt2, 'LIBELLE', $descripteur_spec);
				
				oci_define_by_name($stmt3, 'LIBELLE', $synonyme);
				oci_define_by_name($stmt4, 'EMAIL', $contributeur);
				oci_define_by_name($stmt41, '(DESCRIPTEUR_GEN).LIBELLE', $descripteur_gen);



				oci_execute($stmt);
				oci_execute($stmt11);
				oci_execute($stmt2);
				oci_execute($stmt3);
				//oci_execute($stmt31);
				oci_execute($stmt4);
				oci_execute($stmt41);
				oci_execute($stmt5,OCI_COMMIT_ON_SUCCESS);


				oci_fetch($stmt);
				oci_fetch($stmt11);

				//oci_fetch($stmt3);
				//oci_fetch($stmt31);
				oci_fetch($stmt4);
				oci_fetch($stmt41);


			}
			
			// Si le terme existe
			if ($libelle!="")
			{
				echo "<h1 class=\"titreTerme\">".ucfirst($libelle);
				if (isset($_SESSION['flag']))
					if ($_SESSION['flag'] == true)
					{
						echo " <a href='modifTermeSynonyme.php?nom=$recherche&amp;nomSynonyme=$nomTerme'><img src=\"images/pen2.png\" alt=\"Editer\" /></a>";
						echo " <a href='deleteTermeSyn.php?nom=$recherche&amp;nomSynonyme=$nomTerme'><img src=\"images/poubelle2.png\" alt=\"Supprimer\" /></a>";
					}
				echo "</h1>";
				echo "<p class=\"petit\">Date de création : $dateCreation</p>";
				echo "<p class=\"petit\">Contributeur : $contributeur</p>";
				echo "<p class=\"petit\">Nombre de consultations : $nbConsultations</p>";
				
				echo "<fieldset class=\"fieldsetDef\">";
				echo "<legend>&nbsp;Définition&nbsp;</legend>";
				echo $definition;
				echo "</fieldset>";
				
			
				
				// Descripteur de généralisation
				echo "<p><span class=\"afficTerme\">Descripteur de généralisation :</span>";
				if ($descripteur_gen != NULL)
				{
					echo "<li><a href='terme.php?nomTerme=$descripteur_gen'>".ucfirst($descripteur_gen)."</a></li>";

				}
				else
				{
					echo "Aucun";
				}
				echo "</p>";
				

				// Descripteurs de spécialisation
				echo "<p style=\"margin-top : 30px;\"><span class=\"afficTerme\">Descripteur(s) de spécialisation :</span>";
				echo "<ul>";
				$flagspec = false;
				while(oci_fetch($stmt2))
				{
					if ($descripteur_spec != NULL)
					{

						echo "<li><a href='terme.php?nomTerme=$descripteur_spec'>".ucfirst($descripteur_spec)."</a></li>";
						$flagspec = true;
					}
				}
				echo "</ul>";
				if (!$flagspec)
				{
					echo "Aucun";
				}
				
				//$flagSyn = false;
				// Synonymes
				echo "<p style=\"margin-top : 30px;\"><span class=\"afficTerme\">Synonymes :</span></p>";
				echo "<ul>";
				while (oci_fetch($stmt3))
				{
				
					if ($synonyme != NULL && $synonyme != $nomTerme)
					{

						echo "<li><a href='termeSynonyme.php?nom=$recherche&nomTerme=$synonyme'>" .ucfirst($synonyme)."</a></li>";
						//$flagSyn = true;
					}
				}

				echo "<li style='margin-left : 110px;'><a href='terme.php?nomTerme=$recherche'>".ucfirst($recherche)."</a></li>";
				echo "</ul>";
				
				

				// A REVOIR, traiter le cas de chaque type de mot (concept, termevedette, ensemble_synonyme, ...)
				// Incrémentation du nombre de consultations

			}
			// Si le terme n'existe pas
			else
			{
				echo "<h1>Aucun résultat</h1>";
				echo "<p>Le terme ".ucfirst($recherche)." n'existe pas.</p>";
				if (isset($_SESSION['flag']))
				{
					if ($_SESSION['flag'] == true)
					{
						echo "<p>Vous pouvez <a href=\"ajoutConcept.php\" title=\"Ajouter un concept\">ajouter ce terme en tant que concept</a> si vous le souhaitez.</p>";
					}
				}
			}
			
			oci_free_statement($stmt);
			oci_free_statement($stmt2);
			oci_free_statement($stmt4);
			oci_close($conn);
			
			?>
		</div>
	</div>
	</body>
</html>
