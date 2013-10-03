<?php
	session_start();
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Thesaurus du système immunitaire</title>
		
		<?php include("includes/meta.php"); ?>
		
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
		<script type="text/javascript" src="javascript.js"></script>
		
	</head>
	<body>
	<div id="divIndex">
		<div id="gauche">
			<img src="images/bandeauThesaurus.png" />
		<div id="blocRecherche">
			<?php include("includes/blocRecherche.php"); ?>
		</div>
				<hr />
				
			</form>
		</div>
		<div id="droite">
			<img src="images/bandeauMeConnecter.png" />
			<form method="post" action="checkConnexion.php">
				<p><label for="login">Adresse mail :</label><input type="email" name="login" id="login" required /></p>
				<p><label for="pass">Mot de passe :</label><input type="password" name="pass" id="pass" required /></p>
				<p><input type="submit" value="Connexion" /></p>
			</form>
			<hr style="margin-top : 40px;" />
			<br />
			<p>Vous n'avez pas encore de compte ? <a href="inscription.php">Cliquez ici pour vous inscrire !</a></p>
		</div>
	</div>
	</body>
</html>
