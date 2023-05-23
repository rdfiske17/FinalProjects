<?php
session_start();
if(isset($_POST['submit'])){
$address = $_POST['address'];
$city = $_POST['city'];
$state = $_POST['state'];
$zip = $_POST['zip'];
$CardNum = $_POST['cardnumber'];
$FullAddress = $address . ", " . $city . ", " . $state . ", " . $zip;
try{
    include 'db_connect.php';
    $conn = OpenCon();
    $item1 = $conn->query("SELECT Users.id_item1 from Users WHERE Users.id_user=$user_id;");
    $item2 = $conn->query("SELECT Users.id_item2 from Users WHERE Users.id_user=$user_id;");
    $item3 = $conn->query("SELECT Users.id_item3 from Users WHERE Users.id_user=$user_id;");
    $item4 = $conn->query("SELECT Users.id_item4 from Users WHERE Users.id_user=$user_id;");
    $item5 = $conn->query("SELECT Users.id_item5 from Users WHERE Users.id_user=$user_id;");
    foreach ($item1 as $row) {
        $item1 = $row["id_item1"];
    }
    foreach ($item2 as $row) {
        $item2 = $row["id_item2"];
    }
    foreach ($item3 as $row) {
        $item3 = $row["id_item3"];
    }
    foreach ($item4 as $row) {
        $item4 = $row["id_item4"];
    }
    foreach ($item5 as $row) {
        $item5 = $row["id_item5"];
    }
    

    $sql = $conn->query("INSERT INTO Orders (id_user,shipping_address,total,card_number,id_item1,id_item2,id_item3,id_item4,id_item5) 
                            values ('$user_id','$address','$total','Card',$item1,$item2,$item3,$item4,$item4);");
}   
catch (mysqli_sql_Exception $e) {
    echo "Error: " . $e->getMessage();
}
header("Location: Index.php");
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Checkout</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
  <link rel="stylesheet" type="text/css" href="css/CheckoutStyle.css">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,900" rel="stylesheet">

</head>

<body>

   <div class="container">
    <header>

      <?php include 'header.php'; //Header?>
  </header>
        <header class="checkoutHeader">Checkout</header>
            <form name="checkout" id="checkout" method="post" action="Checkout2.php">
              <label for="fname">Full Name</label>
              <input type="text" id="fname" name="firstname" placeholder="John M. Doe" required>
              <label for="email">Email</label>
              <input type="text" id="email" name="email" placeholder="john@example.com" required>
              <label for="adr"> Address</label>
              <input type="text" id="adr" name="address" placeholder="542 W. 15th Street" required>
              <label for="city">City</label>
              <input type="text" id="city" name="city" placeholder="New York" required>
              <label for="state">State</label>
              <input type="text" id="state" name="state" placeholder="NY" required>
              <label for="zip">Zip</label>
              <input type="text" id="zip" name="zip" placeholder="10001" required>
              <label for="cname">Name on Card</label>
              <input type="text" id="cname" name="cardname" placeholder="John More Doe" required>
              <label for="ccnum">Credit card number</label>
              <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" required>
              <label for="expmonth">Exp Month</label>
              <input type="text" id="expmonth" name="expmonth" placeholder="September" required>
              <button type="submit" id="submit" name="submit">Go</button>
            </form>
            
            <div class="subtotal">
            <?php
                    try {
                        include 'db_connect.php';
                        $conn = OpenCon();
                        //echo "Successful Connection!";
                        $subtotal =0;
                        $user_id = $_SESSION["UserSession"];
                        $result1 = $conn->query("SELECT product_price FROM Products, Users WHERE (id_product=id_item1 AND Users.id_user='$user_id');");
                        $result2 = $conn->query("SELECT product_price FROM Products, Users WHERE (id_product=id_item2 AND Users.id_user='$user_id');");
                        $result3 = $conn->query("SELECT product_price FROM Products, Users WHERE (id_product=id_item3 AND Users.id_user='$user_id');");
                        $result4 = $conn->query("SELECT product_price FROM Products, Users WHERE (id_product=id_item4 AND Users.id_user='$user_id');");
                        $result5 = $conn->query("SELECT product_price FROM Products, Users WHERE (id_product=id_item5 AND Users.id_user='$user_id');");
                        foreach ($result1 as $row) {
                            $subtotal =$subtotal + $row["product_price"];
                        }
                        foreach ($result2 as $row) {
                            $subtotal =$subtotal + $row["product_price"];
                         }
                         foreach ($result3 as $row) {
                            $subtotal =$subtotal + $row["product_price"];
                            }
                            foreach ($result4 as $row) {
                                $subtotal =$subtotal + $row["product_price"];
                             }
                             foreach ($result5 as $row) {
                                $subtotal =$subtotal + $row["product_price"];
                             }
                             echo '<c>Subtotal</c>';
                             echo '<d>'.$subtotal.'</d><br>';
                             echo '<c>Shipping<c>';
                             $shipping= 3.99;
                             echo '<d>'.$shipping.'</d><br>';
                             echo '<c>Tax<c>';
                             $tax = $subtotal*.07;
                             echo '<d>'.$tax.'</d><br>';
                             echo '<c>Total<c>';
                             $total = $subtotal+$shipping+$tax;
                             echo '<d>'.$total.'</d><br>';
                             CloseCon($conn);
                    }
                    catch (mysqli_sql_Exception $e) {
                        echo "Error: " . $e->getMessage();
                    }
                ?>
          </div>
    

   </div>
   <?php include 'footer.php'; //Footer?>

</body>
</html>