<!DOCTYPE html>
<!-- source: https://designmodo.com/create-product-page/-->
<?php
  try {
    include 'db_connect.php';
    $conn = OpenCon();
    $chosenId = $_GET['productChosen'];
    $result = $conn->query("SELECT * From Products WHERE id_product='$chosenId'");
  }
  catch (mysqli_sql_Exception $e) {
    echo "Error: " . $e->getMessage();
  }

?>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/master.css">
  <link rel="stylesheet" href="https://use.typekit.net/tsz4xpq.css%22%3E">
 <link rel="stylesheet" href="css/productpage.css">
</head>


<body>
  <!-- NAV --> 
  <div class="container">
    <?php include 'header.php' //Header?>
    <div class = "content-flex-box-1">
      <div>
        <div class = "image">
          <?php 
            foreach ($result as $row) {
              echo '<img data-image="red" class="active" src="images/' . $row["product_image"] . '" alt="">';
            }
          ?>
        </div>
        <div class ="description-nest">
          <?php
        
          foreach($result as $row){
            echo '<div class = "product-description"> 
                  <h1>'. $row["product_name"] . '</h1>
                  <p> ' .$row["product_description"] .' </p>
                  </div>
                  ';
          echo '
                  <div class = "product-price">
                  <span> $' . $row["product_price"] .' </span>
                  </div>
                  <a href=""><button type="reset" class="addToCart"><span>Add to Cart</span></button></a>
                  ';
          
          
          }
          ?>
          </div> <!--description-nest end -->
          </div> <!--div after flex box end -->
    </div> <!--Flex box 1 end -->
  </div> <!--Container End -->
    
  <?php include 'footer.php'; //Footer?>
</body>
</html>

  

  