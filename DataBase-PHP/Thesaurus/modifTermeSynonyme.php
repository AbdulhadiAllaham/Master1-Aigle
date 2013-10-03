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
	

		$flagOK = false;
		if (isset($_POST['valider']))
		{	
			$vedette = htmlentities(strtolower($_POST['vedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$def = htmlentities(strtolower($_POST['defVedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$libelle = htmlentities(strtolower($_POST['libelle']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$nomVedette = htmlentities(strtolower($_POST['nomVedette']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$sql2 = "update table(select d.ensemble_synonymes from DescripteurVedette d where d.libelle = '$nomVedette') t set t.libelle = '$vedette', definition = '$def' where t.libelle = '$libelle'";
		
			//echo $sql2;
			$stmt2 = oci_parse($conn, $sql2);
			oci_execute($stmt2);
			//oci_fetch($stmt2);
			$flagOK = true;
		}
		else
		{
			$nom = htmlentities(strtolower($_GET['nom']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			// Champs du terme que l'on veut afficher
			$sql = "select libelle, nomConcept, definition from DescripteurVedette where LOWER(libelle)='".$nom."'";
			
			$stmt = oci_parse($conn,$sql);
			
			oci_define_by_name($stmt, 'LIBELLE', $libelle);
			oci_define_by_name($stmt, 'NOMCONCEPT', $nomConcept);
			oci_define_by_name($stmt, 'DEFINITION', $definition);
			
			oci_execute($stmt);
			
			oci_fetch($stmt);
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
			if ($flagOK == true)
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
						<p><label for="concept">Terme Vedette :</label><?php echo ucfirst($libelle); ?></p>
						<p><label for="vedette">Terme synonyme :</label><input type="text" name="vedette" id="vedette" value="<?php echo ucfirst($_GET['nomSynonyme']); ?>" required /><input type="hidden" name="libelle" value="<?php echo $_GET['nomSynonyme']; ?>" /></p>
					<?php echo "<p><label for=\"defVedette\" class=\"verticalAlign\">Définition : <a href='modifTerme.php?nom=$libelle'><img src=\"images/pen.png\" alt=\"Editer\" /> </label></a>  $definition" ?></textarea></p>
						<p><input type="submit" id="valider" name="valider" value="Valider" /><input type="button" value="Annuler" onclick="history.back();"></p>
<input type="hidden" name="nomVedette" value="<?php echo $nom; ?>" />

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
