<?php
	session_start();
	
	$chaine_hote = 'localhost/XE';
	$login = 'gilles';
	$mdp = 'thesaurus';

	$conn = oci_connect($login, $mdp, $chaine_hote);

	if (!$conn)
	{
		$e = oci_error();   // For oci_connect errors pass no handle
		echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
	}
	else
	{
		/*
			TO DO
		*/
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<title>TITRE</title>
		
		<?php include("meta.php"); ?>
		
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
		<script type="text/javascript" src="javascript.js"></script>
		
	</head>
	<body>
	<div id="bandeau"><a href="index.php"><img src="images/titreBanniere.png" /></a></div>
	<div id="general">
		<div id="blocRecherche">
			<?php include("blocRecherche.php"); ?>
		</div>
		<div id="blocLog">
			<?php include("blocLog.php"); ?>
		</div>
		<div id="contenu">
			<h1>TITRE</h1>
			
		</div>
	</div>
	</body>
</html>
