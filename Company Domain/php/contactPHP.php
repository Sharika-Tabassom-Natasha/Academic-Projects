<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "companydomain");
$link = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);




    if(isset($_POST['button_submit'])){
        $username = strip_tags($_POST['username']);
        $email = strip_tags($_POST['email']);
        $massage = strip_tags($_POST['massage']);

        $sql ="INSERT INTO contact (UserName, Email, Massage) VALUES ('".$username."', '".$email."', '".$massage."')";
        $result = mysqli_query($link,$sql);
        mysqli_close($link);
        header("location:../contact.php");

    }else{

    }

?>
