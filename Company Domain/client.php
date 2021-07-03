<?php
session_start();

if($_SESSION['id']>0){
define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "companydomain");
$link = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);

$sql ="select * from client where ClientId='".$_SESSION['id']."'";

$result = mysqli_query($link,$sql);
$data = mysqli_fetch_assoc($result);

//print_r($data);
$username= $data['Name'];
$img= $data['Image'];
$address= $data['Address'];
$email= $data['Email'];
$coursename= $data['CourseName'];
$courseday= $data['CourseDay'];
$coursehour= $data['CourseHour'];
$courseprice= $data['CoursePrice'];

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
    <link rel="stylesheet" href="css/client.css"/>

     <title>Company Domain</title>
   </head>

   <body>
     <div class="container client">
       <h1>CLIENT <br> INFORMATION</h1>

       <div class="clientInfo">
         <img src="<?php echo $img; ?>" >
         <div class="client-name">
           <h2><?php echo $username; ?></h2>
         </div>
       </div>

       <form action="client.php" method="post">
         <div class="row">

           <div class="col-md-6">
             <h4>Course Information</h4>

             <div class="form">
               <label class="control-label col-sm-5" for="coursename">Course Name:</label>
                <div class="col-sm-5">
                  <?php echo $coursename; ?>
                </div>
              </div>

              <div class="form">
                <label class="control-label col-sm-5" for="courseprice">Course Price:</label>
                <div class="col-sm-5">
                  <?php echo $courseprice; ?>
                </div>
              </div>

              <div class="form">
                <label class="control-label col-sm-5" for="courseday">Course Day:</label>
                <div class="col-sm-5">
                  <?php echo $courseday; ?>
                </div>
              </div>

              <div class="form">
                <label class="control-label col-sm-5" for="coursehour">Course Hour:</label>
                <div class="col-sm-5">
                  <?php echo $coursehour; ?>
                </div>
              </div>

             </div>


             <div class="col-md-6">
               <h4>Contact Information</h4>

               <div class="form">
                 <label class="control-label col-sm-2" for="email">Email:</label>
                 <div class="col-sm-10">
                   <?php echo $email; ?>
                 </div>
               </div>


               <div class="form">
                 <label class="control-label col-sm-2" for="Address">Address:</label>
                 <div class="col-sm-10">
                   <?php echo $address; ?>
                 </div>
               </div>

             </div>


             <div class="form">
               <div class="col-sm-offset-2 col-sm-10">
                 <button type="submit" class="btn btn-default" name="logout">Log Out</button>
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
