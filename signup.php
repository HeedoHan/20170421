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
  
  
$result = mysqli_query($con,"insert into user_app (id,name,pw,pnum,gname,sd,sgg) values ('$id','$name','$pw','$pnum','$gname', '$sd', '$sgg')");  
  
  if($result){  
    echo '가입완료';  
  }  
  else{  
    echo '아이디 중복, 가입 실패';
  }  
  
  
mysqli_close($con);  
?>