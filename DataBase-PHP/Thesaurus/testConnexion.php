<?php 
$chaine_hote="127.0.0.1/XE";
$login="gilles";
$mdp ="thesaurus";

$connect = ocilogon("yasser","yasser",$chaine_hote);
//s$conn = oci_connect($username, $password, $tnsName);

if (!$connect)
{
	$e = oci_error();   // For oci_connect errors pass no handle

	echo '<b><font color="red">FAILED</font></b> : ' . htmlentities($e['message']);
}
else
{
	echo '<b><font color="green">OK!</font></b>';
}

//$stmt = ociparse($connect,"select * from Thesaurus");
//$stmt = ociparse($connect,"select * from Thesaurus");
 
$stmt = ociparse($connect,"select s.nomSynonyme from TermeVedette t,table(t.synonyme) s where lower(t.libelle)='a6211'");
$sNomConcept = ociparse($connect,"select nomConcept from concept");
echo 'selection du Thesaurus reussite';

//ociexecute($stmt[1],OCI_DEFAULT);

while(ocifetch($stmt!=null))
{
	echo ociresult($stmt,1);
}
ocilogoff($connect);
?>
