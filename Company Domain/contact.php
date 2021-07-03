<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/contact.css" />

    <title>Company Domain</title>
</head>
<body>

<?php include 'php/slider.php'; ?>

  <div class="fullPage">
    <img id="contactImage" src="images/contact.jpg">
    <div class="caption">
      <h1>CONTACT</h1>
      <h4>Let's meet together</h4>
    </div>

  <div class="lower">
    <div class="row">

        <div class="col-sm-12 col-md-6 ">
          <div class="lowerForm">
            <h1>Drop us a line</h1>
            <p>Please fell free to drop us a line if you
              <br>have any further questions or concerns.</p>
            <form action="php/contactPHP.php" method="post" role="form">
              <div class="Enter">
                <input type="text" name="username" placeholder="Enter Name" required>
              </div>
              <div class="Enter">
                <input type="text" name="email" placeholder="Email Address" required>
              </div>
              <div class="Enter">
                <textarea name="massage" placeholder="Massage"></textarea>
              </div>
              <div class="submit">
                <button type="submit" class="btn btn-default" name="button_submit">Submit</button>
              </div>
            </form>
          </div>
        </div>

        <div class="col-sm-12 col-md-6 ">
          <div class="row lowerMedia">
            <div class="col-sm-12 col-md-6 LM">
              <img src="images/address.png">
              <div>
                <h5>Address</h5>
                16/2, Road No:2,<br>
                Block:C, Mirpur,<br>
                Australia
              </div>
            </div>
            <div class="col-sm-12 col-md-6 LM">
              <img src="images/clock.png">
              <div>
                <h5>Opening Hour</h5>
                Saturday: 12am to 4pm <br>
                Sunday to Thusday: 10am to 6pm
              </div>
            </div>
            <div class="col-sm-12 col-md-6 LM">
              <img src="images/phone.png">
              <div>
                <h5>Phone</h5>
                Office:0123 456 7890
              </div>
            </div>
            <div class="col-sm-12 col-md-6 LM">
              <img src="images/mail.png">
              <div>
                <h5>Email</h5>
                companyDomain@gmail.com
              </div>
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
