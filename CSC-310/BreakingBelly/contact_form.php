<?php
$visitor_fname = "";
$visitor_lname = "";
$visitor_email = "";
$visitor_phonenumber = "";
$visitor_reasoning = "";
$visitor_subject = "";
$email_body = "<div>";
session_start();


#https://code.tutsplus.com/tutorials/create-a-contact-form-in-php--cms-32314
if (isset($_POST["submitbutton"])) {
 
    $error_msg = "Error:";
   

    $visitor_fname = $_POST['fname'];
    $visitor_lname = $_POST["lname"];
    $visitor_email = $_POST['email'];

    $visitor_subject = $_POST['subject'];

    if ($visitor_fname == ""){
        $error_msg .= "\n First Name is Empty";
    }
    if($visitor_email == ""){
        $error_msg .=  "\n, Last Name is Empty";
        
    }
    else if (!preg_match("/^\S+@\S+\.\S+$/i",$visitor_email)){
        $error_msg .= "\n, Email Does Not Use Proper Formatting (yourname@address.com).";
    
    }

    if ($visitor_subject == ""){
        $error_msg .= "\n, Subject is Empty";
    }


    

    if (isset($_POST["fname1"])) {
        $visitor_fname = filter_var($_POST['fname1'], FILTER_SANITIZE_STRING);
        if($visitor_fname == ""){
            $error_fname=  "<span class='error'>Please enter your name.</span>";
        }
        $email_body .= "<div>
                           <label><b>Visitor First Name:</b></label>&nbsp;<span>".$visitor_fname."</span>
                        </div>";

    }

    if (isset($_POST['lname'])) {
        $visitor_lname = filter_var($_POST['lname'], FILTER_SANITIZE_STRING);
        $email_body .= "<div>
                           <label><b>Visitor Last Name:</b></label>&nbsp;<span>".$visitor_lname."</span>
                        </div>";
    }

    if (isset($_POST['email'])) {
        $visitor_email = str_replace(array("\r", "\n", "%0a", "%0d"), '', $_POST['email']);
        $visitor_email = filter_var($visitor_email, FILTER_VALIDATE_EMAIL);
        $email_body .= "<div>
                           <label><b>Visitor Email:</b></label>&nbsp;<span>".$visitor_email."</span>
                        </div>";
       
    }

    if (isset($_POST['subject'])) {
        $visitor_subject = str_replace(array("\r", "\n", "%0a", "%0d"), '', $_POST['subject']);
        $visitor_subject = filter_var($visitor_subject, FILTER_SANITIZE_STRING);
        $email_body .= "<div>
                           <label><b>Visitor Subject:</b></label>&nbsp;<span>".$visitor_subject."</span>
                        </div>";
    }
    if($error_msg == "Error:"){

    $cookieData = array("visitor_fname" => $visitor_fname,
    "visitor_lname" => $visitor_lname,
    "visitor_email" => $visitor_email,
    "visitor_subject" => $visitor_subject);


    $email_body .= "</div>";
    $expireTime = 0;

    setcookie("cookie1", json_encode($cookieData), $expireTime, "/");
    $recipient = "info@nrdfiske17.com";
    $subject = "Form Submission";
    $headers = "From: info@rdfiske17.com";

      
    if (mail($recipient, $subject, $email_body, $headers)) {
        echo "<p>Thank you for reaching out to me, $visitor_name. I will get back to you ASAP.</p>";
    } else {
        echo '<p>We are sorry but the email did not go through.</p>';
    }

    header("Location: contact.php");


    }
    else {
        echo $error_msg . PHP_EOL;
    }
    
}
?>