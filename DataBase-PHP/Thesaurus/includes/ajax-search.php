<?php
	session_start();
	
	include("./infoConnexion.php");

	$conn = oci_connect($login, $mdp, $chaine_hote);

	if (!$conn)
	{
		$e = oci_error();   // For oci_connect errors pass no handle
		echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
	}
 
	//recherche des résultats dans la base de données
	$string = strtolower($_GET['q']);

	$result = "select libelle from DescripteurVedette where LOWER(libelle) LIKE '$string%' ";
	$stmt = oci_parse($conn,$result);
	oci_define_by_name($stmt, 'LIBELLE', $libelle);

	oci_execute($stmt);


	$sql3 = "select t.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where t.libelle LIKE '$string%'";
	$stmt3 = oci_parse($conn,$sql3);
	oci_define_by_name($stmt3, 'LIBELLE', $synonyme);
	oci_execute($stmt3);

//$sql = "INSERT INTO Concept VALUES ('$nomConcept', '$dateCreation', $nbConsult, '$def', (select ref(p) from Contributeur p where email='$contrib'))";
?>
<?php
	echo "<ul>";
    // parcours et affichage des résultats

	
    while(oci_fetch($stmt))
    {
		echo "<li><a href='terme.php?nomTerme=$libelle'>".ucfirst($libelle)."</a> </li>";


    }

    // parcours et affichage des résultats
    while(oci_fetch($stmt3))
    {

		$sql4 = "select d.libelle from DescripteurVedette d ,table (d.ensemble_synonymes) t where t.libelle LIKE '$string%'";
	$stmt4 = oci_parse($conn,$sql4);
	oci_define_by_name($stmt4, 'LIBELLE', $nomVedette);
	oci_execute($stmt4);
	oci_fetch($stmt4);

		
		echo "<li><a href='termeSynonyme.php?nom=$nomVedette&nomTerme=$synonyme'>".ucfirst($synonyme)."</a> </li>";


    }
	echo "</ul>";

if ($synonyme == '' && $libelle == ''){

?>
    <h3 style="text-align:center; margin:10px 0;">Pas de r&eacute;sultats pour cette recherche</h3>
<?php

}
 
/*****
fonctions
*****/
function safe($var)
{
	$var = mysql_real_escape_string($var);
	$var = addcslashes($var, '%_');
	$var = trim($var);
	$var = htmlspecialchars($var);
	return $var;
}
?>
