<!DOCTYPE html>
<html>
    <head>
        <title>User - Breaking Belly</title>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="css/user.css">
    </head>

    <body>
        <div class="container">

<!-- NAV -->            
    <?php include 'header.php'; //Header?>


<!-- PAGE CONTENT -->           
<h2 class="title">Your Account</h2>
            <div class="content-flexbox1">
                <a href=""><button type="reset" class="yourOrders"><span>Your Orders</span></button></a>
                <a href=""><button type="reset" class="security"><span>Security</span></button></a>
                <a href=""><button type="reset" class="payment"><span>Payment Info</span></button></a>
                <a href=""><button type="reset" class="help"><span>Need Help?</span></button></a>
                <a href=""><button type="reset" class="profiles"><span>Your Profiles</span></button></a>
            </div>

            <h2 class="title">Admin</h2>
            <div class="content-flexbox2">
                <a href=""><button type="reset" class="dashboard"><span>Dashboard</span></button></a>
                <a href=""><button type="reset" class="manageProducts"><span>Manage Products</span></button></a>
            </div>

    </div> <!-- Container End -->

<!-- FOOTER -->
    <?php include 'footer.php'; //Footer?>


    </body>

</html>