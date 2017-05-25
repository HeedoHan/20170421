<?php
$con=mysqli_connect("localhost","hido0604","zpdls0027");  
 
mysqli_set_charset($con,"utf8");
mysqli_select_db($con,"hido0604");
  
if (mysqli_connect_errno($con))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}

$result = mysqli_query($con, "select * from items;");
$response = array();

while($row = mysqli_fetch_array($result))
{
	array_push($response, array("itemNum" => $row[0], "itemType" => $row[1], "itemName" => $row[2], "price" => $row[3], "day" => $row[4], "lentStatus" => $row[5]));
}	
	echo json_encode(array("response" => $response));
	mysqli_close($con);
?>