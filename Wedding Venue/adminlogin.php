<?php
include_once("php/db_connect.php");
session_start();

if (empty($_SESSION['id'])) {
  if (isset($_POST['admin'])) {
    $sql ="select adminID from admin where UserName='".$_POST['name']."' and Password='".md5($_POST['password'])."';";
    $result = mysqli_query($link,$sql);

    if ($data= mysqli_fetch_assoc($result)) {

      $_SESSION['id']=$data['adminID'];
      header("location:admin.php");
    }
    else {
      echo "<script> alert('Incorrect Username or Password'); </script>";
    }
  }
}
else {
  header("location:admin.php");
}
 ?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/home.css" />
    <link rel="stylesheet" href="css/Admin.css" />

    <title>WEDDING</title>
    <title></title>
  </head>
  <body>

    <?php include 'php/slider.php'; ?>


      <div class="venue-page">
        <div id=heading class="col-12">
          <h1>LogIn
        </div>
        <div class="loginform">
          <form class="" action="adminlogin.php" method="POST">
            <input id="input" type="text" name="name" placeholder="User Name" required><br>
            <input id="input" type="password" name="password" placeholder="Password" required><br>
            <input id="button" type="submit" name="admin" value="Admin">
          </form>
        </div>
      </div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
