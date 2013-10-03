<?php
	session_start();
	
	if (isset($_GET['flag']))
	{
		if ($_GET['flag'] == 1)
		{
			session_destroy();
			$_SESSION['flag'] = false;
		}
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Mon Compte</title>
		
		<?php include("includes/meta.php"); ?>
		
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
		
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
			<h2>Mon compte</h2>
			<?php
			if (!isset($_GET['flag']))
			{
			?>
				<p><a href="monCompte.php?flag=1">Me déconnecter</a></p>

				<p><a href="ajoutConcept.php">Ajouter un nouveau concept</a></p>
			<?php
			}
			else
			{
				// Affichage différent selon le lien cliqué
				switch ($_GET['flag'])
				{
					// Déconnexion
					case 1:
						unset($_GET['flag']);
						echo '<p>Déconnexion effectuée.</p>';
						echo '<p><a href="index.php" title="Retour a l\'accueil">Retour à l\'accueil</a></p>';
					break;
					
					// Changement du mot de passe
					case 2:
						// TO DO
					break;
				}
			}
			?>
		</div>
	</div>
	<script src="javascript.js"></script>
	</body>
</html>
