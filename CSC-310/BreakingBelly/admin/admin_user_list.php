<!DOCTYPE HTML>
<html>
    <link rel="stylesheet" href="../css/master.css">
    <body>
        <input type="button" id="prev_page" value="Admin Home" onclick="location.href='../admin_home.php'">
        <br />
        <!label for="filter_by" id="filter_by_label">
        <!input type="text" id="filter_by" name="filter_by">
        <!input type="submit" id="filter_submit" value="Go"> 
        <table id="usertable"> <! https://datatables.net/extensions/select/examples/initialisation/checkbox.html and https://www.washington.edu/accesscomputing/webd2/student/unit2/module5/lesson1.html>
            <caption>Users</caption>
            <thead>
                <tr>
                    <th scope="col" id="user_id">User ID</th>
                    <th scope="col" id="username">User Name</th>
                    <th scope="col" id="email_address">Email Address</th>
                    <th scope="col" id="recent_order">Most Recent Order</th>
                    <th scope="col" id="account_status">Account Status</th>
                </tr>
            </thead>
            <tbody>
                 <!--<tr>
                    <td>testuser1</td>
                    <td>testuser1@breakingbelly.com</td>
                    <td>09/22/22</td>
                </tr>
                <tr>
                    <td>testuser2</td>
                    <td>testuser2@breakingbelly.com</td>
                    <td>07/03/16</td>
                </tr>
                <tr>
                    <td>testuser3</td>
                    <td>testuser3@breakingbelly.com</td>
                    <td>10/12/21</td>
                </tr>-->
                <?php
                    try {
                        include '../db_connect.php';
                        $conn = OpenCon();
                        //echo "Successful Connection!";
                        $result = $conn->query("SELECT * From Users");
                        foreach ($result as $row) {
                            $activation_status = "";
                            if($row["account_active"] == "1") {$activation_status = "Active";} else { $activation_status = "Deactivated";}
                            echo "<tr>
                                    <td>" . $row["id_user"] . "</td>
                                    <td>" . $row["username"] . "</td>
                                    <td>" . $row["email"] . "</td>
                                    <td>" . $row["most_recent_order_date"] . "</td>
                                    <td>" . $activation_status . "</td>";
                        }
                    }
                    catch (mysqli_sql_Exception $e) {
                        echo "Error: " . $e->getMessage();
                    }
                ?>
            </tbody>
        </table>

    
        <input type="button" id="add_users" value="Add Users" onclick="location.href='admin_user_create.php'"> <! https://stackoverflow.com/questions/2906582/how-do-i-create-an-html-button-that-acts-like-a-link>
        <!input type="button" id="reset_passwords" value="Reset Passwords">
        <input type="button" id="ban_users" value="Ban/Unban Users" onclick="location.href='admin_user_ban.php'">
    </body>
</html>