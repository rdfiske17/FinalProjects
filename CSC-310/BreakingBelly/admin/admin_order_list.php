<!DOCTYPE HTML>
<html>
    <link rel="stylesheet" href="../css/master.css">    
    <body>
        <input type="button" id="prev_page" value="Admin Home" onclick="location.href='../admin_home.php'">
        <br />
        <!label for="filter_by" id="filter_by_label">
        <!input type="text" id="filter_by" name="filter_by">
        <!input type="submit" id="filter_submit" value="Go"> 
        <table id="ordertable"> <! https://datatables.net/extensions/select/examples/initialisation/checkbox.html and https://www.washington.edu/accesscomputing/webd2/student/unit2/module5/lesson1.html>
            <caption>Orders</caption>
            <thead>
                <tr>
                    <th scope="col" id="order_no">Order Number</th>
                    <th scope="col" id="username">Username</th>
                    <th scope="col" id="email">Email</th>
                    <th scope="col" id="purchase_date">Purchase Date</th>
                    <th scope="col" id="purchase_total">Purchase Total</th>
                    <th scope="col" id="shipping_address">Shipping Address</th>
                    <th scope="col" id="card_number">Card Number</th>
                    <th scope="col" id="shipping_date">Shipping Date</th>
                    <th scope="col" id="delivery_date">Delivery Date</th>
                    <th scope="col" id="canceled">Order Cancellation</th>
                </tr>
            </thead>
            <tbody>
                <!-- <tr>
                    <td>000000001</td>
                    <td>TestUser1</td>
                    <td>07/03/16</td>
                    <td>$21.19</td>
                    <td>123 Sesame Street</td>
                    <td>Credit Card</td>
                    <td>07/04/16</td>
                    <td>07/10/16</td>
                </tr>
                <tr>
                    <td>000000002</td>
                    <td>TestUser2</td>
                    <td>04/01/19</td>
                    <td>$100,000</td>
                    <td>1600 Pennsylvania Avenue</td>
                    <td>Over the Phone</td>
                    <td>04/01/19</td>
                    <td>04/01/19</td>
                </tr>
                <tr>
                    <td>000000003</td>
                    <td>TestUser3</td>
                    <td>10/15/22</td>
                    <td>$56.99</td>
                    <td>901 8th St S</td>
                    <td>PayPal</td>
                    <td>10/19/22</td>
                    <td>NULL</td>
                </tr> -->
                <?php
                    try {
                        include '../db_connect.php';
                        $conn = OpenCon();
                        //echo "Successful Connection!";
                        $result = $conn->query("SELECT * From Orders");
                        foreach ($result as $row) {
                            $user_id = $row["id_user"];
                            if($row["order_canceled"] == 1) {
                                $canceled = "Canceled";
                            }
                            else {
                                $canceled = "";
                            }                        
                            //echo $user_id;
                            $query_2 = $conn->query("SELECT username,email FROM Users Where id_user = $user_id");
                            $username = "";
                            $email = "";
                            foreach ($query_2 as $row2) {
                                $username = $row2["username"];
                                $email = $row2["email"];
                            }
                            echo "<tr>
                                    <td>" . $row["id_order"] . "</td>
                                    <td>" . $username . "</td>
                                    <td>" . $email . "</td>
                                    <td>" . $row["order_placed_date"] . "</td>
                                    <td> $" . $row["total"] . "</td>
                                    <td>" . $row["shipping_address"] . "</td>
                                    <td>" . $row["card_number"] . "</td>
                                    <td>" . $row["order_shipped_date"] . "</td>
                                    <td>" . $row["order_delivered_date"] . "</td>
                                    <td>" . $canceled . "<td> </tr>";                        }
                    }
                    catch (mysqli_sql_Exception $e) {
                        echo "Error: " . $e->getMessage();
                    }
                ?>
            </tbody>
        </table>

    
        <input type="button" id="create_order" value="Create New Order" onclick="location.href='admin_order_create.php'"> <! https://stackoverflow.com/questions/2906582/how-do-i-create-an-html-button-that-acts-like-a-link>
        <input type="button" id="cancel_order" value="Cancel Orders" onclick="location.href='admin_order_cancel.php'">
    </body>
</html>