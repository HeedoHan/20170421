<?php
$connect=mysql_connect("localhost","hido0604","zpdls0027") or die("faliure");

mysql_select_db("hido0604",$connect);

session_start();

$id = $_POST[u_id];

?>