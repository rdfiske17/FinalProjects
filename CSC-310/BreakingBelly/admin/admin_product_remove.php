<!DOCTYPE html>
<?php
    $db_success = FALSE;

    try {
        include '../db_connect.php';
        $conn = OpenCon();
        //echo "Connection successful!";
        $sql = "SELECT product_name FROM products"; //https://stackoverflow.com/questions/3422168/safest-way-to-get-last-record-id-from-a-table
        $pname_query = $conn->query($sql); //https://www.php.net/manual/en/mysqli.query.php
    }
    catch (mysqli_sql_Exception $e) {
        echo "Error: " . $e->getMessage();
    }
    
    $p_name = "";
    if(isset($_POST['submit'])) {
        $p_name = $_POST['product_name'];
        $product_in_db = FALSE;
        $error_msg = "";

        if($p_name == "") {
            $error_msg .= " <br /> Error: Please fill out all fields";
        }

        foreach ($pname_query as $pn) {
            if ($pn["product_name"] == $p_name) {
                $product_in_db = TRUE;
            }
        }

        if(!$product_in_db)
        {
            $error_msg .= "<br /> Error: Product not in Database";
        }

        if ($error_msg == "") {
            $stmt = $conn->prepare("DELETE FROM products WHERE product_name=?");
            $stmt->bind_param("s",$p_name);
            $stmt->execute();
            //echo "New records created successfully!";
            $db_success = TRUE;
        }

        else {
            echo $error_msg;
        }

        if($db_success == TRUE) {
            echo "Product successfully removed from Database";
        }
    }
?>

<html>
    <link rel="stylesheet" href="../css/master.css">
    <h>
        <p>Remove Product<br/></p>
    </h>
    <body>
        <form id="remove_product" name="remove_product" method="post" enctype="multipart/form-data">
            <label for="product_name">Product Name</label>
            <input type="text" id="product_name" name="product_name"> <! adding name= lets the word username be clicked on site>
            <br />
            <input type="submit" id="submit" name="submit" value="Submit"></input>
        </form> 
        <input type="button" id="prev_page" value="Admin Product Home" onclick="location.href='admin_product_list.php'">
</html>