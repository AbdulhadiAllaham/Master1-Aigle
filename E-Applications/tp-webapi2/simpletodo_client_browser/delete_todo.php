<?php
session_start();
include_once 'apicaller.php';

$apicaller = new ApiCaller('APP001', '28e336ac6c9423d946ba02d19c6a2632', 'http://localhost/tp-webapi2/simpletodo_api/');

//Suprression de la tache
$new_item = $apicaller->sendRequest(array(
	'controller' => 'todo',
	// exécuter l'action delete dans TotoItem.php
	'action' => 'delete',
	'todo_id' => $_GET['todo_id'],
	'username' => $_SESSION['username'],
	'userpass' => $_SESSION['userpass']
));

header('Location: todo.php');
exit();
?>
