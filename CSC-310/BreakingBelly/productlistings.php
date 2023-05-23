<!DOCTYPE html>
<link rel="stylesheet" href="css/productlistings.css">
<link rel="stylesheet" type="text/css" href="css/master.css">
<body>
   <div class = "container">
   <!-- NAV --> 
   <?php include 'header.php' //Header?>
   
   <div class = "listing-section">
      <?php
      include 'db_connect.php';
      $conn = OpenCon();
      $result = $conn->query("SELECT * From Products");
      foreach ($result as $row){
                  echo '<div>';
                 echo '<img src="images/' . $row["product_image"] . '" alt="Rock Candy">';
                  echo '<h1>' . $row["product_name"] . '</h1>';
                  echo '<p>' .$row["product_price"] . '</p>';
                  echo '<p>' .$row["product_description"] . '</p>';
                  echo '<p> <a href="productPage.php?productChosen=' . $row["id_product"] . '">Product Page</a> </p>';

         echo '</div>';
      }
      ?>

   </div>
   </div>
   <?php include 'footer.php' //Footer?>
</body>
