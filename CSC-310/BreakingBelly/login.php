<?php
session_start();
session_unset();
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Breaking Belly</title>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="css/login.css">
    </head>

    <body>
        <div class="container">

<!-- NAV -->            
            <header>


                <?php include 'header.php'; //Header?>
            </header>

<!-- PAGE CONTENT -->
        <div class="loginForm">

            <h1 class="title">Welcome Back!</h1>
            <h2 class="subtitle">Sign in to your account to continue.</h2>
            
            <div class="content-flexbox1">
                <a href=""><button type="reset" class="signInButton"><span>Sign in</span></button></a>
                
                <a href=""><button type="reset" class="signUpButton"><span>Sign up</span></button></a>
            </div>

            <div class="content-flexbox2">
                <form name="login" id="login" method="post" action="login.php">
                <input type="text" id="email" name="email" placeholder="Email"/>
                <input type="text" id="password" name="password" placeholder="Password"/>
                <a><button type="submit" id="submit" name="submit" class="submitButton"><span>Sign in</span></button></a>
                </form>
            </div>
            <?php 
                if(isset($_POST['submit'])){
                    
                    $email = $_POST['email'];
                    $password = $_POST['password'];
                    try{
                        include 'db_connect.php';
                        $conn = OpenCon();
                        $sql = $conn->query("SELECT Users.id_user FROM Users WHERE Users.email='$email' AND Users.password='$password';");
                        foreach($sql as $row){
                        $_SESSION["UserSession"] = $row["id_user"]; 
                        }

                        
                    }   
                    catch (mysqli_sql_Exception $e) {
                        echo "Error: " . $e->getMessage();
                    }
                    header("Location: Index.php");               
                }
                

            ?>
            <div class="content-flexbox3">
                <div class="nested-content-flexbox3">
                    <label for="keepLoggedIn" id="label_keepLoggedIn">
                        <input type="checkbox" id="keepLoggedIn"/>
                        Keep me logged in
                    </label>

                    <a href="" class="forgot">Forgot Password?</a>
                </div>

                
            </div>

        </div>
        
        </div> <!-- Container End -->

<!-- FOOTER -->
<?php include 'footer.php'; //Footer?>

    </body>

</html>