<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <?php
        $cookie_name="visited";
        if (isset($_COOKIE[$cookie_name])) {
         $conn = mysqli_connect("localhost", "admin", "", "test");
         $query="select UserName from users where username='$_COOKIE[$cookie_name]'";
        if( mysqli_query($conn, $query)){
            echo "<meta http-equiv='refresh' content='1,url=index.html'>";
        }else{
            echo 'error occured';
        }
        }
        ?>
        <title></title>
    </head>
    <body>
    <?php 
    setcookie($cookie_name, "Ayomide", time()+86500*7);
    ?>    
    </body>
</html>
