
 <?php
 session_start();
 if($_SESSION['id']>0){
 define("DB_SERVER", "localhost");
 define("DB_USER", "root");
 define("DB_PASSWORD", "");
 define("DB_DATABASE", "companydomain");
 $link = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);

 $sql ="select * from employee where EmployeeId='".$_SESSION['id']."'";

 $result = mysqli_query($link,$sql);
 $data = mysqli_fetch_assoc($result);

//print_r($data);
 $username= $data['Name'];
 $img= $data['Image'];
 $email= $data['Email'];
 $mobile= $data['Mobile'];
 $status= $data['Status'];
 $address= $data['Address'];
 $department= $data['Depertment'];
 $supervisor= $data['Supervisor'];
 if (isset($_POST['Admin'])) {

   if($status === 'Manager'){
   header("location:admin.php");
 }else {
 }

 }

 if (isset($_POST['logout'])) {
     session_unset();
   session_destroy();
   header("location:login.php");
 }

}
 else {
   header("location:login.php");
 }
  ?>


  <!DOCTYPE html>
  <html lang="en" dir="ltr">
    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="css/bootstrap.min.css" />
      <link rel="stylesheet" href="css/employee.css"/>

      <title>Company Domain</title>
    </head>

    <body>

      <div class="container employee">
      <h1>EMPLOYEE INFORMATION</h1>

      <div class="row">

        <div class="col-md-3 employee-info">
          <img src="<?php echo $img; ?>">
          <div class="employee-name">
            <h2><?php echo $username; ?></h2>
          </div>
        </div>

        <div class="col-md-9">

          <form action="employee.php" method="post">
            <div class="row">

              <div class="col-md-6">
                <h3>Contact Information</h3>

                <div class="form">
                  <label class="control-label col-sm-2" for="email">Email:</label>
                  <div class="col-sm-10">
                    <?php echo $email; ?>
                  </div>
                </div>

                <div class="form">
                  <label class="control-label col-sm-2" for="mobile">Mobile:</label>
                  <div class="col-sm-10">
                    <?php echo $mobile; ?>
                  </div>
                </div>

                <div class="form">
                  <label class="control-label col-sm-2" for="Address">Address:</label>
                  <div class="col-sm-10">
                    <?php echo $address; ?>
                  </div>
                </div>

              </div>

              <div class="col-md-6">
                <h3>Additional Information</h3>

                <div class="form">
                  <label class="control-label col-sm-2" for="status">Status:</label>
                  <div class="col-sm-10">
                    <?php echo $status; ?>
                  </div>
                </div>

                <div class="form">
                  <label class="control-label col-sm-2" for="department">Department:</label>
                  <div class="col-sm-10">
                    <?php echo $department; ?>
                  </div>
                </div>

                <div class="form">
                  <label class="control-label col-sm-2" for="supervisor">Supervisor:</label>
                  <div class="col-sm-10">
                    <?php echo $supervisor; ?>
                  </div>
                </div>

              </div>

              <div class="form">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default" name="logout">Log Out</button>
                  <button type="submit" class="btn btn-default" name="Admin">Admin</button>
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
