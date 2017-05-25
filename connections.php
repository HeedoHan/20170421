$hostname_localhost ="localhost";
$database_localhost ="hido0604";
$username_localhost ="hido0604";
$password_localhost ="zpdls0027";
 
$localhost = mysql_connect($hostname_localhost,$username_hido0604,$password_zpdls0027)
or
trigger_error(mysql_error(),E_USER_ERROR);

<?php 
 
  require_once('yourfolder/Connections.php'); 
  mysql_select_db($database_localhost,$localhost);
 
  $useremail = $_POST['UserEmail'];
  $password = $_POST['Password'];
 
  $query_search = "select * from tbl_user where username = '".$useremail."' AND password = '".$password.      
  "'";
   $query_exec = mysql_query($query_search) or die(mysql_error());
 $rows = mysql_num_rows($query_exec);
 
  if($rows --> 0) { 
       echo "Y"; 
  }
  else  {
       echo "N"; 
  }
 
?>