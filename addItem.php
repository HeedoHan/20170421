<?php  
$con=mysqli_connect("localhost","hido0604","zpdls0027");  
 
mysqli_set_charset($con,"utf8");
mysqli_select_db($con,"hido0604");
  
if (mysqli_connect_errno($con))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}

$itemType = $_POST['itemType'];  
$itemName = $_POST['itemName'];
$price = $_POST['price'];
$day = $_POST['day'];
$lentStatus = $_POST['lentStatus'];

  
$result = mysqli_query($con,"insert into items (itemType, itemName, price, day, lentStatus) values ('$itemType','$itemName','$price','$day','$lentStatus')");
  
  
  if($result){  
    echo '추가 완료';  
  }  
  else{  
    echo '추가 실패';
  }  
  
  
mysqli_close($con);  
?>