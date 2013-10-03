<?php
	session_start();

// Fonction remplaçant les caractères spéciaux
function replaceSpecCar($s)
{
	$search = array ('@[éèêëÊË]@i','@[àâäÂÄ]@i','@[îïÎÏ]@i','@[ûùüÛÜ]@i','@[ôöÔÖ]@i','@[ç]@i','@[ ]@i','@[^a-zA-Z0-9_]@');
	$replace = array ('e','a','i','u','o','c','_','');
	return preg_replace($search, $replace, $s);
}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des termes</title>
		
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
	<!--<p><input type="button" name="btnListeTermes" id="btnListeTermes" value="Ajouter Terme" onclick="document.location.href='ajoutConcept.php';" /></p>-->
		<div id="contenu">
			<br /><h1>Liste des termes</h1>
			<?php 
				include("includes/infoConnexion.php");
				
				if (isset($_SESSION['flag']))
				{
					if ($_SESSION['flag'] == true)
					{
						echo "<button type='button' class='btnAjout' onclick='document.location.href=\"ajoutConcept.php\";'>Ajouter un concept</button>";
					}
				}					

				$conn = oci_connect($login, $mdp, $chaine_hote);

				if (!$conn)
				{
					$e = oci_error();   // For oci_connect errors pass no handle

					echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
				}
				else
				{				
					$sql = 'select nomConcept from concept order by nomConcept';
					$stmt = oci_parse($conn,$sql);
					oci_define_by_name($stmt, 'NOMCONCEPT', $nomConcept);

					oci_execute($stmt);
					
					echo "<ul>";
					
					while (oci_fetch($stmt))
					{
						//$sql2 = "select t.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where d.nomConcept='".$nomConcept."'";
						$sql2 = "select libelle from DescripteurVedette where nomConcept='".$nomConcept."'";
						$stmt2 = oci_parse($conn, $sql2);
						oci_define_by_name($stmt2, 'LIBELLE', $libelle);
						oci_execute($stmt2);
						
//						echo "<li><a href='terme.php?nomTerme=$nomConcept'>".ucfirst($nomConcept)."</a>";
//						// Ajout des boutons de modifications si l'utilisateur est connecté
//						if (isset($_SESSION['flag']))
//						{
//							if ($_SESSION['flag'] == true)
//							{
//								echo " <a href='ajoutTerme.php?nom=$nomConcept'><img src=\"images/add.png\" alt=\"Ajout d'un terme\" /></a>";
//								echo " <a href='modifTerme.php?nom=$nomConcept'><img src=\"images/pen.png\" alt=\"Editer\" /></a>";
//								echo " <a href=#><img src=\"images/poubelle.png\" alt=\"Supprimer\" /></a>";
//							}
//						}
						//echo "<ul>";
						
						while (oci_fetch($stmt2))
						{
							$sql3 = "select t.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where d.libelle='".$libelle."' order by t.libelle";
							$stmt3 = oci_parse($conn, $sql3);
							oci_define_by_name($stmt3, 'LIBELLE', $libelleSyn);
							oci_execute($stmt3);
							$libelle = ($libelle);
							echo "<li><a href='terme.php?nomTerme=$libelle'>".ucfirst($libelle)."</a>";
							// Ajout des boutons de modifications si l'utilisateur est connecté
							if (isset($_SESSION['flag']))
							{
								if ($_SESSION['flag'] == true)
								{

									echo " <a href='ajoutTerme.php?nom=$libelle'><img src=\"images/add.png\" alt=\"Ajout d'un terme\" /></a>";
									echo " <a href='modifTerme.php?nom=$libelle'><img src=\"images/pen.png\" alt=\"Editer\" /></a>";
									echo " <a href='deleteTerme.php?nom=$libelle'><img src=\"images/poubelle.png\" alt=\"Supprimer\" /></a>";
								}
							}
							
							echo "</li><ul>";
							while (oci_fetch($stmt3))
							{
								echo "<li><a href='termeSynonyme.php?nom=$libelle&nomTerme=$libelleSyn'>".ucfirst($libelleSyn)."</a>";
								// Ajout des boutons de modifications si l'utilisateur est connecté
								if (isset($_SESSION['flag']))
								{
									if ($_SESSION['flag'] == true)
									{
										echo " <a href='modifTermeSynonyme.php?nom=$libelle&amp;nomSynonyme=$libelleSyn'><img src=\"images/pen.png\" alt=\"Editer\" /></a>";
										echo " <a href='deleteTermeSyn.php?nom=$libelle&amp;nomSynonyme=$libelleSyn'><img src=\"images/poubelle.png\" alt=\"Supprimer\" /></a>";
									}
								}
							}
							echo "</li></ul>";
							
							oci_free_statement($stmt3);
						}
						
						echo "</li>";
						
						oci_free_statement($stmt2);
					}
					
					echo "</ul>";
					
					oci_free_statement($stmt);
					oci_close($conn);
				}
			?>
		</div>
	</div>
	<footer></footer>
	</body>
</html>
