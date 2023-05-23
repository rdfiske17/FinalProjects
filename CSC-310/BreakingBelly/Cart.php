<?php
session_start();
?>


<!DOCTYPE html>
<html>
<head>
	<title>Cart</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
	<link rel="stylesheet" type="text/css" href="css/Cart.css">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,900" rel="stylesheet">
</head>
<body>
<!-- NAV --> 
   <div class="container">
	<header>


		<?php include 'header.php'; //Header?>
	</header>
	<!-- Page Content -->
	<div class="cart">
		<header class="cartHeader">Cart</header>
		<?php
                    try {
                        include 'db_connect.php';
                        $conn = OpenCon();
                        //echo "Successful Connection!";
						$user_id = $_SESSION["UserSession"];
                        $result = $conn->query("SELECT Products.product_name, Products.product_price, Users.account_active, Products.product_image From Products, Users Where Users.id_user='$user_id'");
                        foreach ($result as $row) {
                            $activation_status = "";
                            if($row["account_active"] == "1") {$activation_status = "Active";} else { $activation_status = "Deactivated";}
							echo '<div class="item">';
							$image = $row["product_image"];
							echo '<img src="images/'.$image.' " />';
                            echo '<a class="product_name">'.$row["product_name"].'</a>';
							echo '<a class="product_price">'.$row["product_price"].'</a>';
							echo '</div>';
                        }
                    }
                    catch (mysqli_sql_Exception $e) {
                        echo "Error: " . $e->getMessage();
                    }
				
                ?>
	
		<input class="cartSubmit" type="submit" id="cart_submit" value="Continue to Checkout" onclick="location.href='Checkout2.php'">
	</div>
	<?php include 'footer.php'; //Footer?>
	</div>

</body>
</html>
