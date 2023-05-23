<?php
// session_start();
 $curPageName = substr($_SERVER["SCRIPT_NAME"],strrpos($_SERVER["SCRIPT_NAME"],"/")+1);
// $isAdmin = false;
// include 'db_connect.php';
//                         $conn = OpenCon();
//                         //echo "Successful Connection!";
// 						$user_id = $_SESSION["UserSession"];
//                         $result = $conn->query("SELECT is_admin FROM users where id_user = $user_id");
//                         foreach ($result as $row){
//                             if ($row["is_admin"] == "1"){
//                                 $isAdmin = true;
//                             }
//                         }


    echo '<header>
    <div class="logo">
        <a href="Index.php">
            <img src="images/headerLogo1.png">
            <img src="images/headerLogo2.png" class="img-top">
        </a>
    </div>

    <nav>
        <div class="topNav">
            <ul>
                <li><a '; if($curPageName == "admin_home.php"){echo 'class="active" ' ;} echo 'href="admin_home.php"><b>Admin Home</b></a></li>
                <li><a '; if($curPageName == "Cart.php"){echo 'class="active" ' ;} echo 'href="Cart.php"><b>Cart</b></a></li>
                <li><a '; if($curPageName == "user.php"){echo 'class="active" ' ;} echo 'href="user.php"><b>Profile</b></a></li>
                <!-- ADD SEARCH BAR, CART ICON, PROFILE ICON -->
                <li><a '; if($curPageName == "login.php"){echo 'class="active" ' ;} echo 'href="login.php"><b>Login</b></a></li>
                <li><a '; if($curPageName == "about.php"){echo 'class="active" ' ;} echo 'href="about.php"><b>About</b></a></li>
                <li><a '; if($curPageName == "productlistings.php"){echo 'class="active" ' ;} echo 'href="productlistings.php"><b>Products</b></a></li>
                <li><a '; if($curPageName == "Index.php"){echo 'class="active" ' ;} echo 'href="Index.php?"><b>Home</b></a></li>
            </ul>
        </div>
    </nav>
</header>';
?>