<?php
	session_start();
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
			<h2>Connexion</h2>
			<p>Connexion à votre compte.</p>
			<form method="post" action="checkConnexion.php">
				<fieldset>
					<legend>&nbsp;Connexion&nbsp;</legend>
					<div id="formu2">
						<p><label for="login">Login :</label><input type="text" id="login" name="login" required /></p>
						<p><label for="pass">Mot de passe :</label><input type="password" id="pass" name="pass" required /></p>
					</div>
					<p><input type="submit" value="Valider" class="valid" />&nbsp;<input type="reset" value="Annuler" class="valid"/></p>
				</fieldset>
			</form>
		</div>
	</div>
	</body>
</html>
