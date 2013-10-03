<script type="text/javascript">
<!--
function resettoggle() {
var e = document.getElementById('foo');
e.style.display = 'none';
}

function hideDiv(id){
document.getElementById(id).style.visibility = 'hidden'; 
}

function toggle_visibility(id) {
var e = document.getElementById(id);
if(e.style.display == 'none')
e.style.display = 'block';
else
e.style.display = 'none';
}

function change( el )
{
    if ( el.value === "Ajouter specialisation" )
        el.value = "Cacher termes";
    else
        el.value = "Ajouter specialisation";
}
//-->

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
?>
<!DOCTYPE html>
<html>
	<head>
		<title>Ajout d'un concept</title>
		
		<?php include("includes/meta.php"); ?>
		
		<link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
		<script type="text/javascript" src="javascript.js"></script>
		
	</head>
	<body onLoad="resettoggle()">
	<div id="bandeau"><a href="index.php"><img src="images/titreBanniere.png" /></a></div>
	<div id="general">
		<div id="blocRecherche">
			<?php include("includes/blocRecherche.php"); ?>
		</div>
		<div id="blocLog">
			<?php include("includes/blocLog.php"); ?>
		</div>
		<div id="contenu">
			<h1>Ajouter un concept</h1>
			<form method="post" action="traitementConcept.php">
			<div id="formu2">
				<p><label for="concept">Concept :</label><input type="text" name="concept" id="concept" required /></p>
				<p><label for="vedette">Terme vedette :</label><input type="text" name="vedette" id="vedette" required /></p>
				<p><label for="defVedette" class="verticalAlign">Définition :</label><textarea name="defVedette" id="defVedette" rows="5" cols="50" class="verticalAlign"></textarea></p>
				<p><label for="concept">Généralisation :</label><select name="generalisation" size="1" >
					<option value="NULL"></option>
				<?php 
					
						$sql = 'SELECT libelle from DescripteurVedette';
						$stmt = oci_parse($conn,$sql);
						oci_define_by_name($stmt, 'LIBELLE', $libelle);
						echo "$libelle";
						oci_execute($stmt);
						while (oci_fetch($stmt))
						{
				?>
							<option value="<?php echo $libelle ?>"><?php echo ucfirst($libelle) ?></option>
				<?php
						}
				?>
				</select></p>
				
				<form action="">
				<div id="formu3"  style="display: none;"><br>


				<?php 
					
						$sql = 'SELECT DISTINCT libelle from DescripteurVedette order by libelle';
						$stmt = oci_parse($conn,$sql);
						oci_define_by_name($stmt, 'LIBELLE', $libelle);
						oci_execute($stmt);
						while (oci_fetch($stmt))
						{
				?>
						<input type ="checkbox" name="termes[]" value="<?php echo  $libelle ?>"><?php echo ucfirst($libelle) ?><br>
				<?php
						}
					}
				?>
				</form>
				</div>
				<p><input type="button" id="boutongeneralisation" value="Ajouter specialisation" onclick="toggle_visibility('formu3'), change(boutongeneralisation);" /></p>
				<p><input type="button" id="ajoutSyn" value="Ajouter un synonyme" onclick="createField('ajoutSyn', 'Synonyme', 'terme_synonyme', 'synonyme');" /></p>


						<p><input type="submit" id="valider" name="valider" value="Valider" /><input type="button" value="Annuler" onclick="history.back();"> </p>

			</div>
			</form>
		</div>
	</div>
	</body>
</html>
