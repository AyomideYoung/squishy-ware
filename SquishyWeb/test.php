<!DOCTYPE html>
<html>
<head>
<title>Logged On</title>
</head>
<body>
<?php

$servername = "localhost";
$username = "admin";
$password = "";
$dbname = "test";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection


$sql = "INSERT INTO users (username, password)
VALUES ('John', 'Doe')";

if (mysqli_query($conn, $sql)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);

?>
</body>
</html>