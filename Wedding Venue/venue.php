<?php
include_once("php/db_connect.php");


    $sql ="select * from venue;";
    $result = mysqli_query($link,$sql);

 ?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/home.css" />
    <link rel="stylesheet" href="css/venue.css" />

    <title>WEDDING</title>
    <title></title>
  </head>
  <body>

    <?php include 'php/slider.php'; ?>


      <div class="venue-page">
        <div id=heading class="col-12">
          <h1 class="display-4">Venue</h1>
        </div>

        <div class="hall">
          <h3>Convention Hall</h3>
          <p>Convention Hall was conceived as a place where every generation of the Bangladeshi could find  comfort in various <br> facets of their culture,
            preserve and practice unique traditions and celebrate festivals and social milestones  in a welcoming <br> environment. It is also designed
             to be a Centre where people of other cultures can explore and experience Bangladeshi traditions and values .</p>

        </div>
        <div class="details">

            <?php
            $i=1;
            while ($row = mysqli_fetch_assoc($result)) {
              echo"
              <div id='slides{$i}' style='margin: 80px 150px 60px' class='carousel slide' data-ride='carousel'>
                <ul class='carousel-indicators'>
                  <li data-target='#slides{$i}' data-slide-to='0' class='active'></li>
                  <li data-target='#slides{$i}' data-slide-to='1'></li>
                  <li data-target='#slides{$i}' data-slide-to='2'></li>
                </ul>
                <div class='carousel-inner'>
              <div class='carousel-item active'>
              <img id='Image' src='images/{$row['firstImage']}'>
              </div>
              <div class='carousel-item'>
              <img id='Image' src='images/{$row['secondImage']}'>
              </div>
              <div class='carousel-item'>
              <img id='Image' src='images/{$row['thirdImage']}'>
              </div>
              </div>
              </div>
              <div class='detailvenue'>
              <h3>{$row['venueName']}</h3>
              <details id='facilities' >
              <summary>Facilities & Features</summary>
              <div id='inner'>{$row['venueFacilities']}</div>
              </details>
              </div>

              ";
              $i++;
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
