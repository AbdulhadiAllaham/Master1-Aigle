<?php
	session_start();
	
	if (isset($_POST['valider']))
	{
		include("includes/infoConnexion.php");

		$conn = oci_connect($login, $mdp, $chaine_hote);

		if (!$conn)
		{
			$e = oci_error();   // For oci_connect errors pass no handle

			echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
		}
		else
		{
			$mailPost = strtolower($_POST["mail"]);
			$sql = "select email from contributeur where LOWER(email)='".$mailPost."'";
			$stmt = oci_parse($conn,$sql);
			$flagExistant = false;
			oci_define_by_name($stmt, 'EMAIL', $mail);
			oci_execute($stmt);
			
			// Si l'email est déjà dans la base de données
			while(oci_fetch($stmt))
			{
				if (strtolower($mail) == strtolower($_POST["mail"]))
					$flagExistant = true;
			}
			
			
			oci_free_statement($stmt);
			//oci_close($conn);
		}
	}

?>

<!DOCTYPE html>
<html>
	<head>
		<title>Inscription</title>
		
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
			<h1>Inscription</h1>
			<p>Ce formulaire vous permet de vous inscrire sur le site afin de pouvoir effectuer des modifications dans le thésaurus.</p>
			<?php
			if (isset($flagExistant) && $flagExistant == true)
			{
				echo "<p style=\"color : red;\">Cet email est déjà présent dans notre base de données. Veuillez vous <a href=\"connexion.php\">connecter</a> avec cette adresse ou vous inscrire avec une adresse différente</p>.";
			}
			elseif(isset($flagExistant) && $flagExistant == false)
			{
				$mail = $_POST['mail'];
				$pass = $_POST['pass'];
				$dateInscription = date("d-m-Y");
				
				$sql = "INSERT INTO Contributeur VALUES ('$mail', '$pass', 0, '$dateInscription', '$dateInscription')";
				$stmt = oci_parse($conn,$sql);
				oci_execute($stmt);
				
				$_SESSION['flag'] = true;
				$_SESSION['email'] = $login;
				
				echo "<p style=\"color : green;\">Inscription effectuée !</p>";
			}
			?>
			<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
			<fieldset>
				<legend>&nbsp;Inscription&nbsp;</legend>
				<div id="formu2">
					<p><label for="mail">Mail :</label><input type="text" id="mail" name="mail" required /></p>
					<p><label for="pass">Mot de passe :</label><input type="password" id="pass" name="pass" required /></p>
					<p><label for="confirmPass" class="verticalAlign">Confirmer votre mot de passe :</label><input type="password" id="confirmPass" name="confirmPass" class="verticalAlign" required /></p>
				</div>
				<p><input type="submit" name="valider" value="Valider" class="valid" />&nbsp;<input type="reset" name="annuler" value="Annuler" class="valid"/></p>
			</fieldset>
			</form>
		</div>
	</div>
	</body>
</html>
