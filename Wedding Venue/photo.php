<?php
include_once("php/db_connect.php");

    $sql ="select photo from photo;";
    $result = mysqli_query($link,$sql);

 ?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/photo.css" />

    <title>WEDDING</title>
    <title></title>
  </head>
  <body>

    <?php include 'php/slider.php'; ?>

      <div class="gallery-page">
        <div id=heading class="col-12">
          <h1 class="display-4">Photo Gallery</h1>
        </div>
      </div>

      <div class="gallery">
        <div class="row">

          <?php
          $i=1;
          while ($row=mysqli_fetch_assoc($result)) {
            if ($i<4) {
              echo "
              <div class='col-4' PG>
                <img src='photogallery/{$row['photo']}' alt=''>
              </div>";
              $i++;
            }
            else {
              echo "
              <div class='col-3' PG>
                <img src='photogallery/{$row['photo']}' alt=''>
              </div>";
              $i++;
              if ($i>7) {
                $i=1;
              }
            }
          }
           ?>

        </div>
      </div>





    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
