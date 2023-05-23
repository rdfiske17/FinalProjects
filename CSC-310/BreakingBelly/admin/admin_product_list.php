<!DOCTYPE HTML>
<html>
    <link rel="stylesheet" href="../css/master.css">
    <body>
        <input type="button" id="prev_page" value="Admin Home" onclick="location.href='../admin_home.php'">
        <br />
        <!label for="filter_by" id="filter_by_label">
        <!input type="text" id="filter_by" name="filter_by">
        <!input type="submit" id="filter_submit" value="Go" onclick="location.href='admin_product_list.html'"> 
        <table id="producttable"> <! https://datatables.net/extensions/select/examples/initialisation/checkbox.html and https://www.washington.edu/accesscomputing/webd2/student/unit2/module5/lesson1.html>
            <caption>Products</caption>
            <thead>
                <tr>
                    <th scope="col" id="product_id">Product ID</th>
                    <th scope="col" id="product_name">Product Name</th>
                    <th scope="col" id="product_desc">Description</th>
                    <th scope="col" id="product_price">Price</th>
                    <th scope="col" id="product_image">Image</th>
                </tr>
            </thead>
            <tbody>
                <!--<tr>
                    <td>0001</td>
                    <td>Walter's Classic Blue Razz</td>
                    <td>The classic rock candy brew Breaking Belly is known for.</td>
                    <td>$19.99</td>
                    <td><img src="images/breakingBad-11.png"></td>
                </tr>
                <tr>
                    <td>0002</td>
                    <td>Jesse's Chili Pepper</td>
                    <td>Pinkman's notorious ingredient has blessed many brews including this delicious snack.</td>
                    <td>$19.99</td>
                    <td><img src="images/breakingBad-12.png"></td>
                </tr>
                <tr>
                    <td>0003</td>
                    <td>Los Pollos Hermanos</td>
                    <td>Chicken flavored rock candy? Yes please!</td>
                    <td>$19.99</td>
                    <td><img src="images/breakingBad-13.png"></td>
                </tr> -->
                <?php
                    try {
                        include '../db_connect.php';
                        $conn = OpenCon();
                        //echo "Successful Connection!";
                        $result = $conn->query("SELECT * From Products");
                        foreach ($result as $row) {
                            echo "<tr>
                                    <td>" . $row["id_product"] . "</td>
                                    <td>" . $row["product_name"] . "</td>
                                    <td>" . $row["product_description"] . "</td>
                                    <td>" . $row["product_price"] . "</td>
                                    <td> <img src=\"../images/" . $row["product_image"] . "\"></td>";
                        }
                    }
                    catch (mysqli_sql_Exception $e) {
                        echo "Error: " . $e->getMessage();
                    }
                ?>
            </tbody>
        </table>

    
        <input type="button" id="add_products" value="Add Products" onclick="location.href='admin_product_add.php'"> <! https://stackoverflow.com/questions/2906582/how-do-i-create-an-html-button-that-acts-like-a-link>
        <input type="button" id="remove_products" value="Remove Products" onclick="location.href='admin_product_remove.php'">
        <input type="button" id="upload_images" value="Upload Images" onclick="location.href='admin_product_image_upload.php'">
    </body>
</html>