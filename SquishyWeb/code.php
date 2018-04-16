<!DOCTYPE html>
<html>
<head>
<title>Logged On</title>
</head>
<body>
<?php
$name=$_POST["username"];
$pass=$_POST["pass"];




$quer="insert into users values('$name','$pass')";
$mc = mysqli_connect("localhost","adnei","","test");
if(!$mc){
die("Error Connecting".mysqli_connect_error());
}

if(mysqli_query($mc,$quer)){
echo "Dug";
}else{
echo "Stop".mysqli_error($mc);

}
mysqli_close($mc);

?>
</body>
</html>