<?php
session_start();
$isAdmin = false;
$user_id = -2;
try{
include 'db_connect.php';
                        $conn = OpenCon();
                        //echo "Successful Connection!";
                        if (isset($_SESSION["UserSession"])){
                            $user_id = $_SESSION["UserSession"];
                        }
						
                        $result = $conn->query("SELECT is_admin FROM users where id_user = $user_id");
                        foreach ($result as $row){
                            if ($row["is_admin"] == "1"){
                                $isAdmin = true;
                            }
                        }
}
catch (Exception $e){
    echo"no";
}
if (!$isAdmin){
    echo "boy you thought";
}
else{
    echo '


<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="css/admin_home.css">
        <link rel="stylesheet" href="https://use.typekit.net/tsz4xpq.css">
    </head>

    <body>
        <div class="container">

<!-- NAV --> 
    '; include "header.php"; //Header

echo '
<!-- PAGE CONTENT -->
<h2 class="title">Admin</h2>
            <div class="content-flexbox1">
                <div class="content-flexbox1-item1">
                    <a href="admin/admin_user_list.php"><button type="reset" class="editUsers"><span>Edit Users</span></button></a>
                    <a href="admin/admin_product_list.php"><button type="reset" class="editProducts"><span>Edit Products</span></button></a>
                    <a href="admin/admin_order_list.php"><button type="reset" class="editOrders"><span>Edit Orders</span></button></a>
                </div>
            </div>

        </div> <!-- Container End -->

<!-- FOOTER -->
    ';  include "footer.php";  echo '
    </body>
</html> ';
}
?>