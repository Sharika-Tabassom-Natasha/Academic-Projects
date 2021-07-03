<?php
include_once("php/db_connect.php");

    if(isset($_POST['button_submit'])){
        $username = strip_tags($_POST['username']);
        $email = strip_tags($_POST['email']);
        $massage = strip_tags($_POST['massage']);

        $sql ="INSERT INTO contact (UserName, Email, Massage) VALUES ('".$username."', '".$email."', '".$massage."')";
        $result = mysqli_query($link,$sql);
        mysqli_close($link);
        echo "<script> alert('Massage sent'); </script>";
    }else{

    }

?>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/contact.css" />

    <title>WEDDING</title>
</head>
<body>

<?php include 'php/slider.php'; ?>

  <div class="fullPage">
    <img id="contactImage" src="images/contact.jpg">

  <div class="lower">

        <div class="col-md-12">
          <div class="lowerForm">
            <h1>Drop us a line</h1>
            <p>Please fell free to drop us a line if you
              <br>have any further questions or concerns.</p>
            <form action="contact.php" method="post" role="form">
              <div class="Enter">
                <input type="text" name="username" placeholder="Enter Name" required>
              </div>
              <div class="Enter">
                <input type="text" name="email" placeholder="Email Address" required>
              </div>
              <div class="Enter">
                <textarea name="massage" placeholder="Massage" required></textarea>
              </div>
              <div class="submit">
                <button type="submit" class="btn btn-default" name="button_submit">Submit</button>
              </div>
            </form>
          </div>
        </div>


        <div class="col-md-12 ">
          <div class="row lowerMedia">
            <div class="col-md-3 LM">
              <img src="images/address.jpg">
              <div>
                <h5>Address</h5>
                16/2, Road No:7,<br>
                Block:F, Gulshan,<br>
                Dhaka
              </div>
            </div>
            <div class="col-md-3 LM">
              <img src="images/clock.png">
              <div>
                <h5>Opening Hour</h5>
                Saturday: 12am to 4pm <br>
                Sunday to Thusday: 10am to 6pm
              </div>
            </div>
            <div class="col-md-3 LM">
              <img src="images/phone.png">
              <div>
                <h5>Phone</h5>
                Office:0123 456 7890
              </div>
            </div>
            <div class="col-md-3 LM">
              <img src="images/mail.jpg">
              <div>
                <h5>Email</h5>
                wedding@gmail.com
              </div>
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
