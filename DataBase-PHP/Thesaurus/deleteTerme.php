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
		$flagOK = false;
		if (isset($_GET['nom']))
		{
			$nom = htmlentities($_GET['nom'], ENT_QUOTES | ENT_IGNORE, "UTF-8");
			$sql2 = "DELETE FROM DescripteurVedette cascade where libelle = '$nom'";
			$sql3 = "DELETE FROM Concept cascade where nomConcept = '$nom'";
			$sql20 = "select libelle from DescripteurVedette";
			$stmt20 = oci_parse($conn, $sql20);
			oci_define_by_name($stmt20, 'LIBELLE', $libelle);
			oci_execute($stmt20);
			while(oci_fetch($stmt20))
			{
				$libelleees[] = $libelle;	


			}

			foreach($libelleees as $libelles)
			{
				$sql200 = "select t.libelle from DescripteurVedette d ,table (d.descripteur_spec) t where LOWER(d.libelle)='$libelles'";
				$sql300 = "select (descripteur_gen).libelle from DescripteurVedette where LOWER(libelle)='$libelles'"; 
				$stmt200 = oci_parse($conn, $sql200);
				$stmt300 = oci_parse($conn, $sql300);
				oci_define_by_name($stmt200, 'LIBELLE', $libelless);
				oci_define_by_name($stmt300, 'LIBELLE', $libgen);
				oci_execute($stmt200);	
				oci_execute($stmt300);	
				while(oci_fetch($stmt200))
				{	
					
					if($libelless == $nom)
					{
					$libelless = htmlentities ($libelless , ENT_QUOTES | ENT_IGNORE, "UTF-8");
					$sql201 = "delete from table(select d.descripteur_spec from DescripteurVedette d where d.libelle = '$libelles') t where t.libelle = '$nom'";
					//echo "$sql201 <br>";
					$stmt201 = oci_parse($conn, $sql201);
					oci_execute($stmt201);
			
					}	
				}

				while(oci_fetch($stmt300))
				{	
					//echo "$libgen = $nom";
					if($libgen == $nom)
					{
					$sql301 = "delete from table(select descripteur_gen from DescripteurVedette d where d.libelle = '$libelles') t  where t.libelle = '$nom'";
					$stmt301 = oci_parse($conn, $sql301);
					oci_execute($stmt301);
		
					}	
				}
				
			
			}
			

			//$sql2 = "DELETE FROM DescripteurVedette cascade where libelle = '$nom'";

			$stmt2 = oci_parse($conn, $sql2);
			$stmt3 = oci_parse($conn, $sql3);
			oci_execute($stmt2);
			oci_execute($stmt3);
			//oci_fetch($stmt2);
			//oci_fetch($stmt3);
			$flagOK = true;
			//oci_fetch($stmt2);
		}

	}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Suppression d'un terme</title>
		
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
			<h1>Suppression</h1>
			<?php
			if ($flagOK)
			{
				echo "<p>Suppresion effectuée !</p>";
				echo "<p><a href='listeTermes.php'>Retour à la liste des termes</a></p>";
			}
			else
			{
				echo "<p>Un problème est survenu.</p>";
				echo "<p><a href='listeTermes.php'>Retour à la liste des termes</a></p>";
			}
			?>
		</div>
	</div>
	</body>
</html>
