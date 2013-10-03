<?php

//oracle connection variables
$ora_user = 'gilles'; //username
$ora_pass = 'thesaurus'; //user password
$ora_host = '127.0.0.1'; //host name or server ip address
$ora_db = 'xe'; //database name

// place variable into oci_connect function, then place funtion in variable
$ora_conn = oci_connect($ora_user,$ora_pass,'//'.$ora_host.'/'.$ora_db);

// error handling
if (!ora_conn){ // if variable $ora_conn fails to connect
// do the following if it fails
$ora_conn_erno = oci_error(); // insert oci_error() function into variable
echo ($ora_conn_erno['message']."\n"); // print the $ora_conn_erno variable/oci_error() function selecting only the message (human readable)
oci_close($ora_conn); // close the connection just in case php doesn't close it
} else {
// if it doesn't fail it will proceed with the rest of the script
echo "Connection Succesful\n"; //echo message if connection does not error
oci_close($ora_conn); // close the connection
}

?>


