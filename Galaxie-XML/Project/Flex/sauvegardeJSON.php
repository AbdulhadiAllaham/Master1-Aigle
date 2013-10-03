<html>
<?php
	$json = $_POST["json"];
	if ($fp = fopen("RESSOURCES/geometries.json", "w")) {
		fputs($fp, $json);
		fclose($fp);
	}
        
        header('Location: rendu_webgl_2.html");
?>
</html>
