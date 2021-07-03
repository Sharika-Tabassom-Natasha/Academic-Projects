<?php
include_once("php/db_connect.php");
$selected_date = $_GET['id'];

$sql ="select * from booking where bookingID='$selected_date';";
$result = mysqli_query($link,$sql);
$row= mysqli_fetch_assoc($result);

if(isset($_POST['submit']) && isset($_POST['terms'])){
   $name = strip_tags($_POST['Name']);
    $address = strip_tags($_POST['Address']);
    $email = strip_tags($_POST['Email']);
    $mobile = md5(strip_tags($_POST['mobile']));
    $guestnumber = strip_tags($_POST['numberofguest']);

    $sql ="INSERT INTO confirmbooking(Name,Address,Email,Mobile,GuestNumber,Date,Time,IDBooking)
     VALUES ('".$name."', '".$address."', '".$email."','".$mobile."','".$guestnumber."','".$row['bookingDate']."','".$row['bookingTime']."','".$row['bookingID']."')";
    $result = mysqli_query($link,$sql);

    $sql ="select * from confirmbooking where IDBooking=$selected_date;";
    $result = mysqli_query($link,$sql);
    $row2=mysqli_fetch_assoc($result);
    $id=$row2['ID'];

    $sql ="UPDATE booking SET customer=$id WHERE bookingID=$selected_date";
    mysqli_query($link,$sql);
    mysqli_close($link);
    header("location:booking.php");
    echo "<script> alert('Booking Complete'); </script>";
}else {
  if(isset($_POST['submit'])) {
    echo "<script> alert('Check terms and conditions'); </script>";
  }
  else {

  }

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
    <link rel="stylesheet" href="css/bookingfor.css" />

    <title>WEDDING</title>
    <title></title>
  </head>
  <body>

    <?php include 'php/slider.php'; ?>

    <div class="bookingfor">
      <h1>Confirm booking for</h1>
      <h3><?php echo $row['bookingDate']; ?> at <?php echo $row['bookingTime']; ?></h3>

      <form action="" method="post">
        <div class="row">

          <div class="col-md-6">

            <div class="form">
              <label class="control-label col-sm-4" for="name">Name:</label>
               <div class="col-sm-8">
                 <input type="text" class="form-control" placeholder="Enter Name" name="Name" required>
               </div>
             </div>


               <div class="form">
                 <label class="control-label col-sm-4" for="Address">Address:</label>
                  <div class="col-sm-8">
                    <textarea class="form-control" name="Address" rows="5" placeholder="Enter Address" required></textarea>
                  </div>
                </div>

                <div class="form">
                  <label class="control-label col-sm-4" for="Email">Email:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter Email" name="Email" required>
                   </div>
                 </div>

                <div class="form">
                  <label class="control-label col-sm-4" for="mobile">Mobile Number:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter Mobile Number" name="mobile" required>
                   </div>
                 </div>


               <div class="form">
                <label class="control-label col-sm-4" for="numberofguest">Number Of Guest:</label>
                 <div class="col-sm-8">
                  <input type="text" class="form-control" placeholder="Enter Guest Number" name="numberofguest" required>
                 </div>
               </div>

               <div class="form">
                  <div class="col-sm-offset-2 col-sm-10">
                      <input id="term" type="checkbox" name="terms" value="yes"> Click here to agree our Terms & Conditions.<br>
                  </div>
                  <p>You are requested to deposit the booking money within 72 hours from now. Otherwise your booking will be canceled.</p>
                </div>


             <div class="form">
               <div class="col-sm-offset-2 col-sm-10">
                 <button type="submit" class="btn btn-default" name="submit">Submit</button>
               </div>
             </div>

            </div>

          </div>
        </form>
      </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
