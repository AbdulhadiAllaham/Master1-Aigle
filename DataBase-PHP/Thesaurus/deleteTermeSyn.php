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
		if (isset($_GET['nom']))
		{
			$nom = htmlentities($_GET['nom'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$nomSynonyme = htmlentities($_GET['nomSynonyme'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$sql2 = "delete from table(select d.ensemble_synonymes from DescripteurVedette d where d.libelle = '$nom') t where t.libelle = '$nomSynonyme'";
			$stmt2 = oci_parse($conn, $sql2);
			oci_execute($stmt2);
			
			$flagOK = true;
		}

	}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Suppression d'un terme</title>
		
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
			<h1>Suppression</h1>
			<?php
			if ($flagOK)
			{
				echo "<p>Suppresion effectuée !</p>";
				echo "<p><a href='listeTermes.php'>Retour à la liste des termes</a></p>";
			}
			else
			{
				echo "<p>Un problème est survenu.</p>";
				echo "<p><a href='listeTermes.php'>Retour à la liste des termes</a></p>";
			}
			?>
		</div>
	</div>
	</body>
</html>
