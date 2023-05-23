<!DOCTYPE html>
<?php
    $db_success = FALSE;

    try {
        include '../db_connect.php';
        $conn = OpenCon();
        //echo "Connection successful!";
        $sql = "SELECT id_user,username FROM users"; //https://stackoverflow.com/questions/3422168/safest-way-to-get-last-record-id-from-a-table
        $username_query = $conn->query($sql); //https://www.php.net/manual/en/mysqli.query.php
        $sql = "SELECT id_order,id_user FROM orders";
        $order_query = $conn->query($sql);
        /*foreach ($email_query as $item) {
            echo $item["email"];
        }*/
    }
    catch (mysqli_sql_Exception $e) {
        echo "Error: " . $e->getMessage();
    }
    
    $username = "";
    $user_id = "";
    $order_id = "";
    if(isset($_POST['submit'])) {
        $username = $_POST['username'];
        $order_id = $_POST['id_order'];
        $user_in_db = FALSE;
        $order_in_db = FALSE;
        $error_msg = "";

        if($username == "") {
            $error_msg .= " <br /> Error: Please fill out all fields";
        }

        foreach ($username_query as $un) {
            if ($un["username"] == $username) {
                $user_in_db = TRUE;
                $query_2 = $conn->prepare("SELECT id_user FROM users Where username = ?");
                $query_2->bind_param("s",$username);
                $query_2->execute();
                $result = $query_2->get_result();
                foreach ($result as $user) {
                    $user_id = $user["id_user"];
                }
            }
        }

        if(!$user_in_db)
        {
            $error_msg .= "<br /> Error: User not in Database";
        }

        foreach ($order_query as $oq) {
            if($oq["id_user"] == $user_id && $oq["id_order"] == $order_id) {
                $order_in_db = TRUE;
            }
        }

        if(!$order_in_db) {
            $error_msg .= "<br /> Error: Order not in Database";
        }

        if ($error_msg == "") {
            $stmt = $conn->prepare("UPDATE orders SET order_canceled=1 WHERE id_user=? and id_order=?");
            $stmt->bind_param("ss",$user_id,$order_id);
            $stmt->execute();
            //echo "New records created successfully!";
            $stmt->close();
            $db_success = TRUE;
        }

        if($db_success) {
            echo "Order #" . $order_id . " (" . $username . ") has successfully been canceled.";
        }
        else {
            echo $error_msg;
        }
    }
?>

<html>
    <link rel="stylesheet" href="../css/master.css">
    <h>
        <p>Cancel Order<br/></p>
    </h>
    <body>
        <form id="cancel_order" name="cancel_order" method="post" enctype="multipart/form-data">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="<?php if(isset($username)){echo $username;}?>"> <! adding name= lets the word username be clicked on site>
            <br />
            <label for="id_order">Order ID</label>
            <input type="text" id="id_order" name="id_order" value="<?php if(isset($order_id)){echo $order_id;}?>">
            <br />
            <input type="submit" id="submit" name="submit" value="Submit"></input>
        </form>
        <input type="button" id="prev_page" value="Admin Order Home" onclick="location.href='admin_order_list.php'">
    </body>
</html>