<!DOCTYPE html>
<?php
    $db_success = FALSE;
    
    try {
        include '../db_connect.php';
        $conn = OpenCon();
        //echo "Connection successful!";
        $sql = "SELECT id_product,product_name FROM products"; //https://stackoverflow.com/questions/3422168/safest-way-to-get-last-record-id-from-a-table
        $pname_query = $conn->query($sql); //https://www.php.net/manual/en/mysqli.query.php
        $sql = "SELECT username FROM users"; //https://stackoverflow.com/questions/3422168/safest-way-to-get-last-record-id-from-a-table
        $username_query = $conn->query($sql); //https://www.php.net/manual/en/mysqli.query.php
    }


    catch (mysqli_sql_Exception $e) {
        echo "Error: " . $e->getMessage();
    }

    $username = "";
    $user_id = 0;
    $order_placed_date = date("Y-m-d"); //https://www.w3schools.com/php/php_date.asp
    $shipping_address = "";
    $total = 0;
    $card_number = "";
    $p1id = 0;
    $p2id = 0;
    $p3id = 0;
    $p4id = 0;
    $p5id = 0;

    if(isset($_POST['submit'])) {
        $username = $_POST['username'];
        $shipping_address = $_POST['shipping_address'];
        if(isset($_POST['item1'])) {
            $p1id = $_POST['item1'];
            //echo $p1id;
        }
        if(isset($_POST['item2'])) {
            $p2id = $_POST['item2'];
        }
        if(isset($_POST['item3'])) {
            $p3id = $_POST['item3'];
        }
        if(isset($_POST['item4'])) {
            $p4id = $_POST['item4'];
        }
        if(isset($_POST['item5'])) {
            $p5id = $_POST['item5'];
        }
        

        $sql = "SELECT SUM(product_price) AS total FROM products WHERE id_product = $p1id or id_product = $p2id or id_product = $p3id or id_product = $p4id or id_product = $p5id"; //https://stackoverflow.com/questions/3422168/safest-way-to-get-last-record-id-from-a-table
        $pricesums_query = $conn->query($sql); //https://www.php.net/manual/en/mysqli.query.php

        foreach ($pricesums_query as $orderprice) {
            $total = $orderprice["total"];
            echo $total;
        }
        $card_number = $_POST['card_number'];
        $error_msg = "";

        if($username == "" || $shipping_address == "" || $card_number == "") {
            $error_msg .= "<br /> Error: Please fill out all fields";
        }

        $user_in_db = FALSE;

        foreach ($username_query as $un) {
            if ($un["username"] == $username) {
                $user_in_db = TRUE;
                $query_2 = $conn->prepare("SELECT id_user FROM users Where username = ?");
                $query_2->bind_param("s",$username);
                $query_2->execute();
                $result = $query_2->get_result();
                foreach ($result as $user) {
                    $user_id = $user["id_user"];
                }
            }
        }

        if(!$user_in_db)
        {
            $error_msg .= "<br /> Error: User not in Database";
        }

        if(!preg_match("/^\d{16}$/i",$card_number)) {
            $error_msg .= "<br /> Error: Card Number is not 16 digits long";
        }

        if ($error_msg == "") {
            $stmt = $conn->prepare("INSERT INTO orders (id_user,order_placed_date,shipping_address,total,card_number,id_item1,id_item2,id_item3,id_item4,id_item5)
                                            VALUES (?,?,?,?,?,?,?,?,?,?)");
            $stmt->bind_param("issdsiiiii",$user_id,$order_placed_date,$shipping_address,$total,$card_number,$p1id,$p2id,$p3id,$p4id,$p5id);
            $stmt->execute();
            //echo "New records created successfully!";
            $stmt->close();
            $db_success = TRUE;
        }

        else {
            echo $error_msg;
        }

        if ($db_success == TRUE) {
            echo "Order has successfully been placed";
        }
    }

?>
<html>
    <link rel="stylesheet" href="../css/master.css">
    <h>
        <p>Create Order<br/></p>
    </h>
    <body>
        <form id="add_order" name="add_order" method="post" enctype="multipart/form-data">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="<?php if(isset($username)){echo $username;}?>"> <! adding name= lets the word username be clicked on site>
            <br />

            <label for="shipping_address">Shipping Address</label>
            <input type="text" id="shipping_address" name="shipping_address" value="<?php if(isset($shipping_address)){echo $shipping_address;}?>">
            <br />

            <label for="item1">Item 1</label>
            <select list="item1" name="item1" id="item1" list="items">
                <?php
                    foreach ($pname_query as $productname)
                    {
                        echo "<option value=\"" . $productname["id_product"] . "\">" . $productname["product_name"] . "</option>";
                    }
                
                ?>
            </select>
            <br />

            <label for="item2">Item 2</label>
            <select list="item2" name="item2" id="item2" list="items">
                <?php
                    foreach ($pname_query as $productname)
                    {
                        echo "<option value=\"" . $productname["id_product"] . "\">" . $productname["product_name"] . "</option>";
                    }
                
                ?>
            </select>
            <br />

            <label for="item3">Item 3</label>
            <select list="item3" name="item3" id="item3" list="items">
                <?php
                    foreach ($pname_query as $productname)
                    {
                        echo "<option value=\"" . $productname["id_product"] . "\">" . $productname["product_name"] . "</option>";
                    }
                
                ?>
            </select>
            <br />

            <label for="item4">Item 4</label>
            <select list="item4" name="item4" id="item4" list="items">
                <?php
                    foreach ($pname_query as $productname)
                    {
                        echo "<option value=\"" . $productname["id_product"] . "\">" . $productname["product_name"] . "</option>";
                    }
                
                ?>
            </select>
            <br />

            <label for="item5">Item 5</label>
            <select list="item5" name="item5" id="item5" list="items">
                <?php
                    foreach ($pname_query as $productname)
                    {
                        echo "<option value=\"" . $productname["id_product"] . "\">" . $productname["product_name"] . "</option>";
                    }
                
                ?>
            </select>
            <br />

            <label for="card_number">Card Number</label>
            <input type="text" id="card_number" name="card_number" value="<?php if(isset($card_number)){echo $card_number;}?>">
            <br />

            <input type="submit" id="submit" name="submit" value="Submit"></input>
        </form>
        <input type="button" id="prev_page" value="Order Admin Home" onclick="location.href='admin_order_list.php'">
    </body>
</html>