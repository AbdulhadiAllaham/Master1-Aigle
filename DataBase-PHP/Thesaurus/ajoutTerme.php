<script type="text/javascript">
function Refresh(id){
location.href="ajoutTerme.php?nom=" + id
}

</script>
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
		if (isset($_GET['nom']))
		{
			$nomConcept = htmlentities(strtolower($_GET['nom']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
		}
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Ajout d'un terme</title>
		
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
			<h1>Ajouter un terme</h1>
			<?php
			if (isset($_POST['valider']))
			{
				$concept = htmlentities(strtolower($_POST['concept']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
			//	echo "concept $concept";
			//	$sql = "SELECT libelle FROM DescripteurVedette WHERE libelle='$libelle'";
			//		echo ($sql);
			//	$stmt = oci_parse($conn,$sql);
			//	oci_define_by_name($stmt, 'DEFINITION', $definition);
			//	$r = oci_execute($stmt);
			//	oci_fetch($stmt);
			//	echo "definition $defintion";
				
				$flagOK = true;
				$libelle = $concept;
				//echo "libelle : $libelle";

				// Récupération des synonymes
				$sql2 = "select t.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where (d.libelle)='$libelle'";
				$terme = htmlentities(strtolower($_POST['terme']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
				//echo "$sql2";
				$verifDoublure = true;
				$stmt2 = oci_parse($conn, $sql2);
				oci_define_by_name($stmt2, 'LIBELLE', $libelleSyn);
				$r2 = oci_execute($stmt2);
				
				while(oci_fetch($stmt2))
				{
					if($libelleSyn == $terme )
					{
						$verifDoublure = false;
						echo "Terme synonyme existe déjà !";
						$flagOK = false;
					}					
				}	
				//echo "libelle : $libelleSyn";
				
				if (!$r2)
				{
					$flagOK = false;
				}
				else
				{
					
					$def = htmlentities($_POST['defTerme'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
					$dateCreation = date("d-m-Y");
					$contrib = $_SESSION['email'];
					$concept = htmlentities(strtolower($_POST['concept']), ENT_QUOTES | ENT_IGNORE, "UTF-8");
					//echo "concept2 $concept";

					
					$def = str_replace ("'", "''", $def);
			$def = str_replace ("’", "''", $def);
					// Requête SQL différente s'il s'agit d'un 1er ajout de synonyme ou non
					// 1er ajout
					if ($libelleSyn == '')
					{
					
						$sql3 = "UPDATE DescripteurVedette set ensemble_synonymes = (ensemble_synonyme(DescripteurSynonyme('$terme', '$dateCreation', 0, '$def',(select ref(p) from Contributeur p where p.email='$contrib')))) where libelle = '$concept'";

						//echo "$sql3";
						$stmt3 = oci_parse($conn,$sql3);
						$r3 = oci_execute($stmt3);
						//echo "emptyyy";
						if (!$r3) $flagOK = false;
					}
					// S'il y a déjà un synonyme, la requête est différente
					else if ($libelleSyn != $terme )
					{

						$sql3 = "INSERT INTO TABLE (select ensemble_synonymes from DescripteurVedette where libelle='$concept') VALUES (DescripteurSynonyme('$terme', '$dateCreation', 0, '$def',(select ref(p) from Contributeur p where p.email='$contrib')))";
						$stmt3 = oci_parse($conn,$sql3);
						$r3 = oci_execute($stmt3);
						if (!$r3) $flagOK = false;
					}
				}
				
				if ($flagOK)
				{
					echo '<p>Ajout réussi !</p>';
				}
				else
				{
					echo '<p>Un problème est survenu.</p>';
				}
				
			}
			else
			{
			?>
			<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
			<div id="formu2">
				<p><label for="concept">Terme vedette :</label><select name="concept" onchange = Refresh(this.value)  size="1">
				<?php 
				$sql = 'SELECT libelle from DescripteurVedette';
				$sql2 = "SELECT definition FROM DescripteurVedette WHERE libelle='$nomConcept'";
				//echo ($sql2);
				$stmt2 = oci_parse($conn,$sql2);
				oci_define_by_name($stmt2, 'DEFINITION', $definition);
				oci_execute($stmt2);
				oci_fetch($stmt2);
				//echo "definition $definition";
				$stmt = oci_parse($conn,$sql);
				oci_define_by_name($stmt, 'LIBELLE', $concept);
				
				//echo "$concept";
				oci_execute($stmt);
				while (oci_fetch($stmt))
				{

				?>
					<option value="<?php echo $concept ?>" <?php if($nomConcept == $concept) {?> selected<?php } ?>><?php echo ucfirst($concept) ?></option>
				<?php
				}
				?>
				</select></p>
				<p><label for="terme">Synonyme :</label><input type="text" name="terme" id="terme" required /></p>
				<p><label for="defVedette" class="verticalAlign">Définition :</label><textarea name="defTerme" id="defTerme" rows="5" cols="50" class="verticalAlign"><?php echo $definition; ?></textarea></p>
						<p><input type="submit" id="valider" name="valider" value="Valider" /><input type="button" value="Annuler" onclick="history.back();"> </p>
			</div>
			</form>
			<?php
			}
			?>
		</div>
	</div>
	</body>
</html>
