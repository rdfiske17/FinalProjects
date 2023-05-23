<!DOCTYPE html>
<?php
    $db_success = FALSE;

    try {
        include '../db_connect.php';
        $conn = OpenCon();
        //echo "Connection successful!";
        $sql = "SELECT username FROM users"; //https://stackoverflow.com/questions/3422168/safest-way-to-get-last-record-id-from-a-table
        $username_query = $conn->query($sql); //https://www.php.net/manual/en/mysqli.query.php
        $sql = "SELECT email FROM users";
        $email_query = $conn->query($sql);
        /*foreach ($email_query as $item) {
            echo $item["email"];
        }*/
    }
    catch (mysqli_sql_Exception $e) {
        echo "Error: " . $e->getMessage();
    }
    
    $username = "";
    if(isset($_POST['submit'])) {
        $username = $_POST['username'];
        $user_in_db = FALSE;
        $error_msg = "";

        if($username == "") {
            $error_msg .= " <br /> Error: Please fill out all fields";
        }

        foreach ($username_query as $un) {
            if ($un["username"] == $username) {
                $user_in_db = TRUE;
            }
        }

        if(!$user_in_db)
        {
            $error_msg .= "<br /> Error: User not in Database";
        }

        if ($error_msg == "") {
            $stmt = $conn->prepare("SELECT account_active FROM users WHERE username=?");
            $stmt->bind_param("s",$username);
            $stmt->execute();
            //echo "New records created successfully!";
            $result = $stmt->get_result(); //https://www.php.net/manual/en/mysqli.quickstart.prepared-statements.php Example #7

            foreach ($result as $element) {
                if($element['account_active'] == 0) {
                    $stmt = $conn->prepare("UPDATE users SET account_active=1 WHERE username=?");
                    $stmt->bind_param("s",$username);
                    $stmt->execute();
                    //echo "New records created successfully!";
                    $stmt->close();
                    $db_success = TRUE;
                    echo $username . "'s account has successfully been reactivated.";
                }
                else {
                    $stmt = $conn->prepare("UPDATE users SET account_active=0 WHERE username=?");
                    $stmt->bind_param("s",$username);
                    $stmt->execute();
                    //echo "New records created successfully!";
                    $stmt->close();
                    $db_success = TRUE;

                    echo $username . "'s account has successfully been deactivated.";
                }
            }
        }

        else {
            echo $error_msg;
        }
    }

?>

<html>
    <link rel="stylesheet" href="../css/master.css">
    <h>
        <p>Ban/Unban User <br/></p>
    </h>
    <body>
        <form id="ban_user" name="ban_user" method="post" enctype="multipart/form-data">
            <label for="username">Username</label>
            <input type="text" id="username" name="username"> <! adding name= lets the word username be clicked on site>
            <br />
            <input type="submit" id="submit" name="submit" value="Submit"></input>
        </form>
        <input type="button" id="prev_page" value="Admin User Home" onclick="location.href='admin_user_list.php'">
</html>