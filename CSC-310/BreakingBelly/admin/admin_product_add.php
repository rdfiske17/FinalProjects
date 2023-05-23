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
    $p_desc = "";
    $p_price = "";
    $p_image = "";

    if(isset($_POST['submit'])) {
        $p_name = $_POST['product_name'];
        $p_desc = $_POST['product_desc'];
        $p_price = $_POST['product_price'];
        $p_image = $_POST['filepath'];
        $error_msg = "";

        if($p_name == "" || $p_desc == "" || $p_price == "" || $p_image == "") {
            $error_msg .= "<br /> Error: Please fill out all fields";
        }

        foreach ($pname_query as $element) {
            if($element["product_name"] == $p_name) {
                $error_msg .= "<br /> Error: Product Name already exists";
            }
        }

        if(is_numeric($p_price)) { //https://www.w3schools.com/php/php_numbers.asp
            $p_price = floatval($p_price); //https://www.php.net/manual/en/function.floatval.php
        }
        else {
            $error_msg .= "<br /> Error: Price is not numeric";
        }

        if ($error_msg == "") {
            $stmt = $conn->prepare("INSERT INTO products (product_name,product_description,product_price,product_image)
                                            VALUES (?,?,?,?)");
            $stmt->bind_param("ssds",$p_name,$p_desc,$p_price,$p_image);
            $stmt->execute();
            //echo "New records created successfully!";
            $stmt->close();
            $db_success = TRUE;
        }
        else {
            echo $error_msg;
        }

        if($db_success == TRUE) {
            echo "Product successfully added to Database";
        }
    }
?>

<html>
    <link rel="stylesheet" href="../css/master.css">
    <h>
        <p>Add Product<br/></p>
    </h>
    <body>
        <form id="add_product" name="add_product" method="post" enctype="multipart/form-data">
            <label for="product_name">Product Name</label>
            <input type="text" id="product_name" name="product_name" value="<?php if(isset($p_name)){echo $p_name;}?>"> <! adding name= lets the word username be clicked on site>
            <br />

            <label for="product_desc">Product Description</label>
            <input type="text" id="product_desc" name="product_desc" value="<?php if(isset($p_desc)){echo $p_desc;}?>">
            <br />

            <label for="product_price">Product Price</label>
            <input type="text" id="product_price" name="product_price" value="<?php if(isset($p_price)){echo $p_price;}?>">
            <br />

            <label for="product_image">Product Image Filename</label>
            <input type="text" id="filepath" name="filepath" value="<?php if(isset($p_image)){echo $p_image;}?>">
            <br />

            <input type="submit" id="submit" name="submit" value="Submit"></input>
        </form>
        <input type="button" id="prev_page" value="Product Admin Home" onclick="location.href='admin_product_list.php'">
    </body>
</html>