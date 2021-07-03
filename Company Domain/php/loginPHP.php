<?php

define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "companydomain");
$link = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);
session_start();

          //client button start
          if (isset($_POST['Client'])) {
            $sql ="select ClientId from client where UserName='".$_POST['name']."' and Password='".md5($_POST['password'])."';";
            $result = mysqli_query($link,$sql);
            $data = mysqli_fetch_assoc($result);

            if ($data) {

              $_SESSION['id']=$data['ClientId'];
              header("location:../client.php");
            }
            else {
              header("location:../login.php?wronginput1");

            }
          }
          else {
          }//client button finish

          if (isset($_POST['Employee'])) {
            $sql ="select EmployeeId from employee where UserName='".$_POST['name']."' and Password='".md5($_POST['password'])."';";
            $result = mysqli_query($link,$sql);
            $data = mysqli_fetch_assoc($result);

            if ($data) {
              session_start();
              $_SESSION['id']=$data['EmployeeId'];
              header("location:../employee.php");
            }
            else {
              $_SESSION['massage'] = 'wrong';
              header("location:../login.php?wronginput2");
            }
          }
          else {
          }//admin button finish


?>
