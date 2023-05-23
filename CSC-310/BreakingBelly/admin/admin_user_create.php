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
    $email_address = "";
    $password = "";
    //$element_array = array($username,$email_address,$password);

    if(isset($_POST['submit'])) {
        $username = $_POST['username'];
        $email_address = $_POST['email_address'];
        $password = $_POST['password'];
        $error_msg = "";

        if($username == "" || $email_address == "" || $password == "") {
            $error_msg .= " <br /> Error: Please fill out all fields";
        }
        
        foreach ($username_query as $un) {
            if ($un["username"] == $username) {
                $error_msg .= " <br /> Error: Username already exists"; //https://www.w3schools.com/php/func_string_nl2br.asp
            }
        }

        foreach ($email_query as $em) {
            if ($em["email"] == $email_address) {
                $error_msg .= " <br /> Error: Email Address already exists";
            }
        }

        if (!preg_match("/^\S+@\S+\.\S+$/i",$email_address)) {
            $error_msg .= " <br /> Error: Invalid Email Address Format";
        }

        if ($error_msg == "") {
            $stmt = $conn->prepare("INSERT INTO users (username,email,password)
                                            VALUES (?,?,?)");
            $stmt->bind_param("sss",$username,$email_address,$password);
            $stmt->execute();
            //echo "New records created successfully!";
            $stmt->close();
            $db_success = TRUE;
        }
        else {
            echo $error_msg;
        }

        if($db_success == TRUE) {
            echo "User successfully added to Database";
        }
    }

?>

<html>
    <link rel="stylesheet" href="../css/master.css">
    <h>
        <p>Add User <br/></p>
    </h>
    <body>
        <form id="create_user" name="create_user" method="post" enctype="multipart/form-data">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="<?php if(isset($username)){echo $username;}?>"> <! adding name= lets the word username be clicked on site>
            <br />

            <label for="email_address">Email Address</label>
            <input type="text" id="email_address" name="email_address" value="<?php if(isset($email_address)){echo $email_address;}?>">
            <br />

            <label for="password">Password</label>
            <input type="text" id="password" name="password" value="<?php if(isset($password)){echo $password;}?>">
            <br />

            <input type="submit" id="submit" name="submit" value="Submit"></input>
        </form>
        <input type="button" id="prev_page" value="User Admin Home" onclick="location.href='admin_user_list.php'">
    </body>
</html>