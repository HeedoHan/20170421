<?php
$con=mysqli_connect("localhost","hido0604","zpdls0027");  
 
mysqli_set_charset($con,"utf8");
mysqli_select_db($con,"hido0604");
  
if (mysqli_connect_errno($con))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}

$id = $_POST['id'];
$name = $_POST['name'];
$pw = $_POST['pw'];
$pnum = $_POST['pnum'];
$gname = $_POST['gname'];
$sd = $_POST['sd'];
$sgg = $_POST['sgg'];

$statement = mysqli_prepare($con, "select * from user_app WHERE id = ? AND pw = ?");
mysqli_stmt_bind_param($statement, "ss", $id, $pw);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $id, $name, $pw, $pnum, $gname, $sd, $sgg);

$response = array();
$response["success"] = false;	

while(mysqli_stmt_fetch($statement))
	{
		$response["success"] = true;
		$response["id"] = $id;
		$response["name"] = $name;
		$response["pw"] = $pw;		
		$response["pnum"] = $pnum;
		$response["gname"] = $gname;
		$response["sd"] = $sd;
		$response["sgg"] = $sgg;
	}

	echo json_encode($response);
	
?>