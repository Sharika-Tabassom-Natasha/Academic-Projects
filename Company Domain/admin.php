<?php

session_start();

if($_SESSION['id']>0){
define("DB_SERVER", "localhost");
define("DB_USER", "root");
define("DB_PASSWORD", "");
define("DB_DATABASE", "companydomain");
$link = mysqli_connect(DB_SERVER , DB_USER, DB_PASSWORD, DB_DATABASE);


    if(isset($_POST['client'])){
       $clientimage = strip_tags($_POST['clientimage']);
        $clientname = strip_tags($_POST['clientname']);
        $username = strip_tags($_POST['Username']);
        $password = md5(strip_tags($_POST['Password']));
        $address = strip_tags($_POST['Address']);
        $email = strip_tags($_POST['Email']);
        $coursename = strip_tags($_POST['coursename']);
        $courseday = strip_tags($_POST['courseday']);
        $coursehour = strip_tags($_POST['coursehour']);
        $courseprice = strip_tags($_POST['courseprice']);

        $sql ="INSERT INTO client (Image, Name, UserName, Password, Address, Email, CourseName, CourseDay, CourseHour, CoursePrice)
         VALUES ('".$clientimage."', '".$clientname."', '".$username."','".$password."', '".$address."', '".$email."','".$coursename."', '".$courseday."', '".$coursehour."', '".$courseprice."')";
        $result = mysqli_query($link,$sql);
        mysqli_close($link);

    }else {
    }

    if (isset($_POST['clientdelete'])) {
      $usernamee = strip_tags($_POST['Username']);
      $sql ="delete from client where UserName='$usernamee';";
      $result = mysqli_query($link,$sql);
        mysqli_close($link);
    }else {
    }

    if(isset($_POST['employee'])){
       $employeeimage = strip_tags($_POST['employeeimage']);
        $employeename = strip_tags($_POST['employeename']);
        $eusername = strip_tags($_POST['eusername']);
        $epassword = md5(strip_tags($_POST['epassword']));
        $eaddress = strip_tags($_POST['eaddress']);
        $eemail = strip_tags($_POST['eemail']);

        $estatus = strip_tags($_POST['estatus']);
        $edepertment = strip_tags($_POST['edepertment']);
        $emobile = strip_tags($_POST['emobile']);
        $esupervisor = strip_tags($_POST['esupervisor']);

        $sql ="INSERT INTO employee (Image, Name, UserName, Password, Email, Mobile,Status,Address,Depertment,Supervisor)
         VALUES ('".$employeeimage."', '".$employeename."', '".$eusername."','".$epassword."','".$eemail."','".$emobile."', '".$estatus."', '".$eaddress."','".$edepertment."', '".$esupervisor."')";
        $result = mysqli_query($link,$sql);
        mysqli_close($link);

    }else{

    }

    if (isset($_POST['employeedelete'])) {
      $eusernamee = strip_tags($_POST['eusername']);
      $sql ="delete from employee where UserName='$eusernamee';";
      $result = mysqli_query($link,$sql);
        mysqli_close($link);
    }else {
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
      <link rel="stylesheet" href="css/admin.css"/>

      <title>Company Domain</title>
    </head>

    <body>
      <div class="container client">
        <h1>INFORMATION</h1>

        <form action="admin.php" method="post">
          <div class="row">

            <div class="col-md-6">
              <h4>Client Information</h4>

              <div class="form">
                <label class="control-label col-sm-4" for="clientname">Client Name:</label>
                 <div class="col-sm-8">
                   <input type="text" class="form-control" placeholder="Enter Client Name" name="clientname" >
                 </div>
               </div>

               <div class="form">
                 <label class="control-label col-sm-4" for="clientimage">Client Image:</label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="Enter image URL" name="clientimage">
                  </div>
                </div>

                <div class="form">
                  <label class="control-label col-sm-4" for="UserName">User Name:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter user name" name="Username">
                   </div>
                 </div>

                <div class="form">
                  <label class="control-label col-sm-4" for="Password">Password:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter password" name="Password">
                   </div>
                 </div>

                 <div class="form">
                   <label class="control-label col-sm-4" for="Address">Address:</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" placeholder="Enter Address" name="Address">
                    </div>
                  </div>

                  <div class="form">
                    <label class="control-label col-sm-4" for="Email">Email:</label>
                     <div class="col-sm-8">
                       <input type="text" class="form-control" placeholder="Enter Email" name="Email">
                     </div>
                   </div>




              <div class="form">
                <label class="control-label col-sm-4" for="coursename">Course Name:</label>
                 <div class="col-sm-8">
                   <input type="text" class="form-control" placeholder="Enter coursename" name="coursename">
                 </div>
               </div>

               <div class="form">
                 <label class="control-label col-sm-4" for="courseprice">Course Price:</label>
                 <div class="col-sm-8">
                   <input type="text" class="form-control" placeholder="Enter courseprice" name="courseprice">
                 </div>
               </div>

               <div class="form">
                 <label class="control-label col-sm-4" for="courseday">Course Day:</label>
                 <div class="col-sm-8">
                   <input type="text" class="form-control" placeholder="Enter courseday" name="courseday">
                 </div>
               </div>

               <div class="form">
                 <label class="control-label col-sm-4" for="coursehour">Course Hour:</label>
                 <div class="col-sm-8">
                   <input type="text" class="form-control" placeholder="Enter coursehour" name="coursehour">
                 </div>
               </div>

               <div class="form">
                 <div class="col-sm-offset-2 col-sm-10">
                   <button type="submit" class="btn btn-default" name="client">Client</button>
                   <button type="submit" class="btn btn-default" name="clientdelete">Delete</button>
                 </div>
               </div>

              </div>


              <div class="col-md-6">
                <h4>Employee Information</h4>

                <div class="form">
                  <label class="control-label col-sm-4" for="employeename">Employee Name:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter Employee Name" name="employeename">
                   </div>
                 </div>

                 <div class="form">
                   <label class="control-label col-sm-4" for="employeeimage">Employee Image:</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" placeholder="Enter image URL" name="employeeimage">
                    </div>
                  </div>

                 <div class="form">
                   <label class="control-label col-sm-4" for="eusername">User Name:</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" placeholder="Enter User Name" name="eusername">
                    </div>
                  </div>

                  <div class="form">
                    <label class="control-label col-sm-4" for="epassword">password:</label>
                     <div class="col-sm-8">
                       <input type="text" class="form-control" placeholder="Enter password" name="epassword">
                     </div>
                   </div>

                   <div class="form">
                     <label class="control-label col-sm-4" for="eemail">Email:</label>
                     <div class="col-sm-8">
                       <input type="text" class="form-control" placeholder="Enter email" name="eemail">
                     </div>
                   </div>

                   <div class="form">
                     <label class="control-label col-sm-4" for="emobile">eMobile Number:</label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Enter mobile number" name="emobile">
                      </div>
                    </div>

                    <div class="form">
                      <label class="control-label col-sm-4" for="estatus">Status:</label>
                      <div class="col-sm-8">
                        <input type="text" class="form-control" placeholder="Enter status" name="estatus">
                      </div>
                    </div>


                   <div class="form">
                     <label class="control-label col-sm-4" for="eaddress">Address:</label>
                     <div class="col-sm-8">
                       <input type="text" class="form-control" placeholder="Enter address" name="eaddress">
                     </div>
                   </div>

                <div class="form">
                  <label class="control-label col-sm-4" for="edepertment">Depertment:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter Depertment" name="edepertment">
                   </div>
                 </div>

                 <div class="form">
                   <label class="control-label col-sm-4" for="esupervisor">Supervisor:</label>
                   <div class="col-sm-8">
                     <input type="text" class="form-control" placeholder="Enter Supervisor" name="esupervisor">
                   </div>
                 </div>

                 <div class="form">
                   <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default" name="employee">Employee</button>
                     <button type="submit" class="btn btn-default" name="employeedelete">Delete</button>
                   </div>
                 </div>

                </div>

              <div class="form">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default log" name="logout">Log Out</button>
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
