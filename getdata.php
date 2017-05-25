<?php  
 
function unistr_to_xnstr($str){ 
    return preg_replace('/\\\u([a-z0-9]{4})/i', "&#x\\1;", $str); 
} 
 
$con=mysqli_connect("localhost","hido0604","zpdls0027","hido0604");  
  
if (mysqli_connect_errno($con))  
{  
   echo "Failed to connect to MySQL: " . mysqli_connect_error();  
}  
 
 
mysqli_set_charset($con,"utf8");  
 
 
$res = mysqli_query($con,"select * from user_app where where id = ? AND pw = ?");  
   
$result = array();  
   
while($row = mysqli_fetch_array($res)){  
  array_push($result,  
    array('id'=>$row[0],'name'=>$row[1],'pw'=>$row[2],'pnum'=>$row[3],'gname'=>$row[4],'sd'=>$row[5],'sgg'=>$row[6] 
    ));  
}  
   
 
$json = json_encode(array("result"=>$result));
echo $json; 
   
mysqli_close($con);   
?>