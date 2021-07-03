<?php
include_once("php/db_connect.php");
session_start();

if (isset($_SESSION['id'])) {
  $sql ="select * from confirmbooking;";
  $result = mysqli_query($link,$sql);

  if (isset($_POST['Insert'])) {

    $date = strtotime(strip_tags($_POST['date']));
    $newformat = date('Y-m-d',$date);
    $time = strtotime(strip_tags($_POST['time']));
      $newformat1 = date('H:i:s',$time);

    $sql ="INSERT INTO booking(bookingDate,bookingTime) VALUES ('".$newformat."', '".$newformat1."')";
    $result1 = mysqli_query($link,$sql);
    echo "<script> alert('Data Added'); </script>";
  }

  if (isset($_POST['logout'])) {
    session_unset();
    session_destroy();
    header("location:adminlogin.php");
  }
}
else {
  header("location:adminlogin.php");
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
          <h1 class="display-4">Admin</h1>
        </div>

        <div class="insertdata">
            <div class="loginform">
              <h3>Insert Vacant Date</h3>
              <form class="" action="admin.php" method="POST">
                <input id="input" type="text" name="date" placeholder="Enter Date"><br>
                <input id="input" type="text" name="time" placeholder="Enter Time" ><br>
                <input id="button" type="submit" name="Insert" value="Insert">
              </form>
          </div>

        </div>


        <div class="showdata">
          <h3>Booking Details</h3>

          <div class="row">
              <?php
              while ($data=mysqli_fetch_assoc($result)) {
                  echo "
                  <div class='col-sm-6 col-md-4 admin'>
                  <ul>
                  <li>
                  <div> ID: {$data['ID'] }</div>
                  <div> Name: {$data['Name']} </div>
                  <div> Address: {$data['Address'] }</div>
                  <div> Email: {$data['Email']} </div>
                  <div> Phone Number: {$data['Mobile'] }</div>
                  <div> Number Of Guest: {$data['GuestNumber']} </div>
                  <div> Event Date: {$data['Date'] }</div>
                  <div> Event Time: {$data['Time']} </div>
                  </li>
                  </ul>
                  </div>";
              }
              ?>
            <form action="" method="post">
              <div class="col-sm-offset-2 col-sm-10">
                <button id="button1" type="submit" class="btn btn-default" name="logout">Log Out</button>
              </div>
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
