<img src="images/bandeauMonCompte.png" />
<?php
	// Si l'utilisateur s'est connecté
	if (isset($_SESSION['flag']))
	{
		if ($_SESSION['flag'] == true)
		{
	?>
			<p class="classLog"><a href="monCompte.php" title="Mon compte">Mon compte</a><br />
			<a href="monCompte.php?flag=1" title="Me déconnecter">Me déconnecter</a></p>
	<?php
		}
		else
		{
	?>
			<p class="classLog"><a href="connexion.php" title="Se connecter">Se connecter</a><br />
			<a href="inscription.php" title="S'inscrire">S'inscrire</a></p>
	<?php
		}
	}
	// S'il n'y a pas eu d'authentification
	else
	{
	?>
		<p class="classLog"><a href="connexion.php" title="Se connecter">Se connecter</a><br />
		<a href="inscription.php" title="S'inscrire">S'inscrire</a></p>
	<?php
	}
?>