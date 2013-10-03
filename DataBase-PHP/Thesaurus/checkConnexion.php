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
		$login = strtolower($_POST['login']);
		$sql = "select * from contributeur where email='".$login."'";
		$stmt = oci_parse($conn,$sql);
		oci_define_by_name($stmt, 'MOTDEPASSE', $pass);

		oci_execute($stmt);
		
		$flagOK = false;
		
		// Si l'email est dans la base de données
		while(oci_fetch($stmt))
		{
			if (strtolower($login) == strtolower($_POST["login"]))
				$flagOK = true;
		}
		
		if ($flagOK)
		{
			// Vérification du mot de passe
			if ($pass == $_POST['pass'])
			{
				$_SESSION['flag'] = true;
				$_SESSION['email'] = $login;
			}
			else
			{
				$flagOK = false;
			}
		}
		
		oci_free_statement($stmt);
		oci_close($conn);
	}
?>


<!DOCTYPE html>
<html>
	<head>
		<title>Connexion</title>
		
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
			<h1>Connexion</h1>
			<?php 
				// Indique que la connexion a fonctionné
				if ($flagOK)
				{
					echo '<p>Connexion effectuée.</p>';
					echo '<p><a href="monCompte.php">Accéder à mon compte</a></p>';
				}
				
				// ou indique si elle a échoué
				else
				{
					echo '<p>Login ou mot de passe incorrect.</p>';
					echo '<p><a href="connexion.php" >Retour à l\'écran de connexion</a></p>';
				}
			?>
		</div>
	</div>
	</body>
</html>
