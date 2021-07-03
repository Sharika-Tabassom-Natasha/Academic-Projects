<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/login.css" />

    <title>Company Domain</title>
</head>
<body>

<?php include 'php/slider.php'; ?>

<div class="fullpage">
<div class="container divcontainer">

  <div class="loginform">

    <img src="images/loginlogo.png" alt="">
    <h3>Sign In</h3>
    <form class="" action="php/loginPHP.php" method="POST">
      <input id="input" type="text" name="name" placeholder="User Name" required><br>
      <input id="input" type="password" name="password" placeholder="Password" required><br>
      <input id="button" type="submit" name="Client" value="Client">
      <input id="button" type="submit" name="Employee" value="Employee">
    </form>

  </div>

</div>
</div>



  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
  </html>
