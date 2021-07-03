<?php
include_once("php/db_connect.php");

    $sql ="select * from booking where customer IS NULL;";
    $result1 = mysqli_query($link,$sql);
    $result2 = mysqli_query($link,$sql);

 ?>


<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/booking.css" />

    <title>WEDDING</title>
</head>
<body>

<?php include 'php/slider.php'; ?>


  <div class="booking-page">
    <div id=heading class="col-12">
      <h1 class="display-4">Booking Information</h1>
    </div>

    <div >
      <h4>AVAILABLE DATES FOR BOOKING</h4>
    </div>

    <div >
      <div class="bookingcolumn">
        <div class="row">

          <div class="col-3 BC">
            <ul class="morning">
              <h5>Morning</h5>
              <?php
              while ($data1=mysqli_fetch_assoc($result1)) {
                if ($data1['bookingTime']=='12:00:00') {
                  echo "<li class=''>
                  <a id='link' href='forbooking.php?id={$data1['bookingID']}'>
                  <div> {$data1['bookingDate']} </div>
                  <div> {$data1['bookingTime'] }</div></a>
                  </li>";
                }
              }
              ?>
            </ul>
          </div>

          <div class="col-3 BC">
            <ul class="evening">
              <h5>Evening</h5>
              <?php
              while ($data2=mysqli_fetch_assoc($result2)) {
                if ($data2['bookingTime']=='18:00:00') {
                  echo "<li class=''>
                  <a id='link' href='forbooking.php?id={$data2['bookingID']}'>
                  <div> {$data2['bookingDate']} </div>
                  <div> {$data2['bookingTime'] }</div></a>
                  </li>";
                }
              }
              ?>
            </ul>
          </div>

        </div>
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
