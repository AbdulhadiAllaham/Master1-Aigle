

 <script type="text/javascript">
    function updatevariable(data) { 
        value = data;
        alert(value);
    } 
 </script>

<?php
	session_start();
	
	include("includes/infoConnexion.php");

	$conn = oci_connect($login, $mdp, $chaine_hote);

	if (!$conn)
	{
		$e = oci_error();   // For oci_connect errors pass no handle
		echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
	}
	else
	{
		if (isset($_POST['valider']))
		{
			$flagOK = true;
			$vedette = htmlentities(strtolower($_POST['vedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$def = htmlentities($_POST['defVedette'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$libelle = htmlentities(strtolower($_POST['libelle']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$contrib = $_SESSION['email'];
			$gen1 = htmlentities($_POST['generalisation'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$gen2 = htmlentities($_POST['generalisation'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$dateCreation = date("d-m-Y");
			
			
			// Généralisation
			$sqlGen = "select (descripteur_gen).libelle from DescripteurVedette where LOWER(libelle)='$libelle'";
			$stmtGen = oci_parse($conn, $sqlGen);
			oci_define_by_name($stmtGen, '(DESCRIPTEUR_GEN).LIBELLE', $oldGen);
			$r = oci_execute($stmtGen);
			if (!$r) $flagOK = false;
			oci_fetch($stmtGen);
			
			// Si le terme de généralisation a changé, il faut mettre à jour l'ancien (avant de le changer dans le terme)
			if ($oldGen != $gen1)
			{
				if ($oldGen != "" && $oldGen != "NULL" && $oldGen != NULL)
				{
					// Suppression de la spécialisation dans l'ancien terme de généralisation
					$sqlGen2 = "delete from table(select d.descripteur_spec from DescripteurVedette d where d.libelle = '$oldGen') t where t.libelle = '$libelle'";
					$stmtGen2 = oci_parse($conn, $sqlGen2);
					$r = oci_execute($stmtGen2);
					if (!$r) $flagOK = false;
				}
				
				// Récupération des spécialisations du nouveau terme de généralisation (pour savoir s'il faut utiliser UPDATE ou INSERT)
				$sqlGen2 = "SELECT t.libelle FROM DescripteurVedette d ,table (d.descripteur_spec) t WHERE (d.libelle)='$gen2'";
				$stmtGen2 = oci_parse($conn, $sqlGen2);
				oci_define_by_name($stmtGen2, 'LIBELLE', $libelleSpecGen);
				$r = oci_execute($stmtGen2);
				if (!$r) $flagOK = false;
				
				$listSpecGen = array();
				while (oci_fetch($stmtGen2))
				{
					array_push($listSpecGen, $libelleSpecGen);
				}
				
				if (empty($listSpecGen))
					$sqlGen21 = "UPDATE DescripteurVedette SET descripteur_spec = (ensemble_specialisation(ens_descr('$vedette', '$dateCreation', 0, '', (select ref(p) from Contributeur p where email='$contrib')))) where libelle = '$gen2'";
				else
					$sqlGen21 = "INSERT INTO TABLE (select descripteur_spec from DescripteurVedette where libelle='$gen2') VALUES (ens_descr('$vedette', '$dateCreation', 0, '',(select ref(p) from Contributeur p where p.email='$contrib')))";
				
				$stmtGen21 = oci_parse($conn, $sqlGen21);
				$r = oci_execute($stmtGen21);
				if (!$r) $flagOK = false;
			}
			
			
			// Récupération des spécialisations du terme
			$sql2 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where (d.libelle)='$vedette'";
			$stmt2 = oci_parse($conn, $sql2);
			oci_define_by_name($stmt2, 'LIBELLE', $libellespecialisation);
			$r2 = oci_execute($stmt2);
			if (!$r2) $flagOK = false;
			
			$listSpec = array();
			while (oci_fetch($stmt2))
			{
				array_push($listSpec, $libellespecialisation);
			}
			
			$arraytermes = array();
			if(isset($_POST['termes']))
			{
				foreach($_POST['termes'] as $termess)
				{
					array_push($arraytermes, htmlentities($termess, ENT_QUOTES | ENT_IGNORE, "UTF-8"));
				}
			}

			// Suppression de la généralisation des anciennes spécialisations
			$result = array_diff($listSpec, $arraytermes); // $result contiendra les spécialisations ayant été décochées
			foreach($result as $value)
			{
				$sqlDel = "UPDATE DescripteurVedette set descripteur_gen = NULL where libelle ='$value'";
//"DELETE FROM DescripteurVedette cascade where libelle = '$value' and descripteur_gen = (select descripteur_gen from DescripteurVedette d where (descripteur_gen).libelle = '$libelle')";
				//echo $sqlDel;
				$stmtDel = oci_parse($conn, $sqlDel);
				$r = oci_execute($stmtDel);

				$sqlDel2 = "delete from table(select d.descripteur_spec from DescripteurVedette d where d.libelle = '$vedette') t where t.libelle = '$value'";

				//echo $sqlDel2;
				$stmtDel2 = oci_parse($conn, $sqlDel2);
				oci_execute($stmtDel2);
				
				if (!$r) $flagOK = false;
			}
			
			// Spécialisation
			if (isset($_POST['termes']))
			{
				foreach($_POST['termes'] as $chkbx)
				{
					$chkbx = htmlentities($chkbx, ENT_QUOTES | ENT_IGNORE, "UTF-8");
					// Vérification des doublons pour les spécialisations
					$flagDoublon = false;
					foreach ($listSpec as $value)
					{
						if ($value == $chkbx)
						{
							$flagDoublon = true;
						}
					}
					unset($value);
					
					// Si ce n'est pas un doublon, on insère
					if (!$flagDoublon)
					{
						// 1ère insertion
						if (empty($listSpec))
						{
							$sqlSpec = "UPDATE DescripteurVedette SET descripteur_spec = (ensemble_specialisation(ens_descr('$chkbx', '$dateCreation', 0, '', (select ref(p) from Contributeur p where email='$contrib')))) where libelle = '$vedette'";
						array_push($listSpec, "super");

						//echo $sqlSpec;
						}
						else
						{
							$sqlSpec = "INSERT INTO TABLE (select descripteur_spec from DescripteurVedette where libelle='$vedette') VALUES (ens_descr('$chkbx', '$dateCreation', 0, '',(select ref(p) from Contributeur p where p.email='$contrib')))";
						}
						$stmtSpec = oci_parse($conn, $sqlSpec);
						$r = oci_execute($stmtSpec);
						if (!$r) $flagOK = false;
					}
					
					
					/*$verifDoublure = true;
					while(oci_fetch($stmt2))
					{
						if($libellespecialisation == $chkbx )
						{
							$verifDoublure = false;
							echo "doublure";
						}
					}*/
					
					// Mise à jour du nouveau terme de spécialisation (en lui indiquant que son terme de généralisation devient le terme en train d'être modifié)
					$sql211 =" update DescripteurVedette set descripteur_gen = (select ref(p) from DescripteurVedette p where p.libelle = '$vedette') where libelle = '$chkbx'";
					$stmt211 = oci_parse($conn, $sql211);
					oci_execute($stmt211);
					
					// Récupération des spécialisations du nouveau terme de généralisation
					$sql212 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where d.libelle='$gen2'";
					$stmt212 = oci_parse($conn, $sql212);
					oci_define_by_name($stmt212, 'LIBELLE', $libellegeneralisation);
					oci_execute($stmt212);
					
					while(oci_fetch($stmt212))
					{
						if ($libellegeneralisation == $chkbx)
						{
							$sql213 = "delete from table(select d.descripteur_spec from DescripteurVedette d where d.libelle = '$gen2') t where t.libelle = '$chkbx'";
							//echo $sql213;
					
							$stmt213 = oci_parse($conn, $sql213);
							oci_execute($stmt213);
						}
					}

					/*if ($libellespecialisation == '')
					{
						echo "libelle spec $libellespecialisation";
						// Comme il s'agit d'une 1ere insertion, on utilise UPDATE
						$sql4 = "UPDATE DescripteurVedette SET descripteur_spec = (ensemble_specialisation(ens_descr('$chkbx', '$dateCreation', 0, '', (select ref(p) from Contributeur p where email='$contrib')))) where libelle = '$vedette'";
						echo $sql4;
						$stmt4 = oci_parse($conn, $sql4);
						$r = oci_execute($stmt4);
						if (!$r) $flagOK = false;
					}
					else if ($verifDoublure != false)
					{
						echo $chkbx;
						$sql3 = "INSERT INTO TABLE (select descripteur_spec from DescripteurVedette where libelle='$vedette') VALUES (ens_descr('$chkbx', '$dateCreation', 0, '',(select ref(p) from Contributeur p where p.email='$contrib')))";
						echo $sql3;
						$stmt3 = oci_parse($conn,$sql3);
						$r3 = oci_execute($stmt3);
						if (!$r3) $flagOK = false;
					}*/
				}
			}
			
			if ($gen1 != "NULL")
			{
				$gen1 = "(SELECT REF(P) FROM DescripteurVedette P WHERE P.libelle='$gen1')";
			}
			
			$def = str_replace ("'", "''", $def);
			$def = str_replace ("’", "''", $def);

			// Modification DescripteurVedette
			$sql2 = "UPDATE DescripteurVedette SET libelle = '$vedette', definition = '$def', descripteur_gen = $gen1  where LOWER(libelle) = '$libelle'";
			// Modification Concept
			$sql21 = "UPDATE Concept SET nomConcept = '$vedette', definition_concept = '$def' where LOWER(nomConcept) = '$libelle'";
			
			$stmt2 = oci_parse($conn, $sql2);
			$r = oci_execute($stmt2);
			if (!$r) $flagOK = false;
			
			$stmt21 = oci_parse($conn, $sql21);
			$r = oci_execute($stmt21);
			if (!$r) $flagOK = false;
		}
		// Affichage du terme
		else
		{
			$nom = htmlentities(strtolower($_GET['nom']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			// Champs du terme que l'on veut afficher
			$sql = "select libelle, nomConcept, definition from DescripteurVedette where LOWER(libelle)='$nom'";
			// Récupération des descripteurs de spécialisation
			$sql2 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where LOWER(d.libelle)='$nom'";
			// Récupération du descripteur de généralisation
			$sql3 = "select (descripteur_gen).libelle from DescripteurVedette where LOWER(libelle)='$nom'";
			
			$stmt = oci_parse($conn,$sql);
			$stmt2 = oci_parse($conn,$sql2);
			$stmt3 = oci_parse($conn,$sql3);
			
			oci_define_by_name($stmt, 'LIBELLE', $libelle);
			oci_define_by_name($stmt, 'NOMCONCEPT', $nomConcept);
			oci_define_by_name($stmt, 'DEFINITION', $definition);
			
			oci_define_by_name($stmt2, 'LIBELLE', $spec);
			
			oci_define_by_name($stmt3, '(DESCRIPTEUR_GEN).LIBELLE', $gen);
			
			oci_execute($stmt);
			oci_execute($stmt2);
			oci_execute($stmt3);
			
			oci_fetch($stmt);
			oci_fetch($stmt3);
			
			$listSpec = array();
			while (oci_fetch($stmt2))
			{
				array_push($listSpec, $spec);
			}
		}
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Modification d'un terme</title>
		
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
			<h1>Modification</h1>
			<?php
			if (isset($_POST['valider']) && $flagOK == true)
			{
				echo '<p>Modification effectuée !</p>';
			}
			else
			{
			// Si le terme existe
				if ($libelle!="")
				{
			?>
				<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
					<div id="formu2">
						<p><label for="concept">Concept :</label><?php echo ucfirst($nomConcept); ?></p>
						<p><label for="vedette">Terme vedette :</label><input type="text" name="vedette" id="vedette" value="<?php echo ucfirst($libelle); ?>" required /><input type="hidden" name="libelle" value="<?php echo $libelle; ?>" /></p>
						<p><label for="defVedette" class="verticalAlign">Définition :</label><textarea name="defVedette" id="defVedette" rows="5" cols="50" class="verticalAlign"><?php echo ucfirst($definition); ?></textarea></p>
						<p><label for="generalisation">Généralisation :</label><select name="generalisation"  size="1" >
							<option value="NULL"></option>
						<?php 
							
								$sql = 'SELECT libelle from DescripteurVedette';
								$stmt = oci_parse($conn,$sql);
								oci_define_by_name($stmt, 'LIBELLE', $libelleSelect);
								//echo "$libelle";
								oci_execute($stmt);
								while (oci_fetch($stmt))
								{
									if ($nomConcept != $libelleSelect)
									{						
						?>
									<option value="<?php echo $libelleSelect ?>"<?php if ($libelleSelect == $gen) { ?> selected<?php } ?>><?php  if ($nomConcept != $libelleSelect) echo ucfirst($libelleSelect) ?></option>
						<?php
									}
								}
						?>
						</select></p>
						<p><label for="specialisation">Spécialisation :</label><br />
						<?php
							$sql = 'SELECT DISTINCT libelle from DescripteurVedette order by libelle';
							$stmt = oci_parse($conn,$sql);
							oci_define_by_name($stmt, 'LIBELLE', $libelleSpec);
							oci_execute($stmt);
							while (oci_fetch($stmt))
							{
								$flagSpec = false;
								foreach($listSpec as &$value)
								{
									if ($libelleSpec == $value)
										$flagSpec = true;
								}
								unset($value);
								if ($nomConcept != $libelleSpec)
								{						
						?>
							<input type ="checkbox" name="termes[]" value="<?php echo  $libelleSpec ?>"<?php if ($flagSpec) { ?> checked<?php } ?>/><?php echo ucfirst($libelleSpec) ?><br>
						<?php
								}
							}
						?>
						</p>
						<p><input type="submit" id="valider" name="valider" value="Valider" /><input type="button" value="Annuler" onclick="history.back();"> </p>
					</div>
					</form>
			<?php
				}
			}
			?>
		</div>
	</div>
	</body>

</html>
