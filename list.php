<?php
$con=mysqli_connect("localhost","hido0604","zpdls0027");  
 
mysqli_set_charset($con,"utf8");
mysqli_select_db($con,"hido0604");
  
if (mysqli_connect_errno($con))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}

$result = mysqli_query($con, "select * from user_app;");
$response = array();

while($row = mysqli_fetch_array($result))
{
	array_push($response, array("id" => $row[0], "pw" => $row[1], "name" => $row[2], "pnum" => $row[3], "gname" => $row[4], "sd" => $row[5], "sgg" => $row [6]));
}

echo json_encode(array("response" => $response));

mysqli_close($con);
?>
	