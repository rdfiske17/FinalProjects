<!DOCTYPE html>
<script type = text/javascript>    
    function validate(){ 
    var isValid = true;
    const form = document.forms['contacthtml'];

    const allFieldLabels = ["fname", "lname", "email", "subject"];
    const fieldType = ["name", "name", "email", "text"];
    const error_texts = [];

    for (const element of allFieldLabels) {
                  document.getElementById(element).className = "";    
              }
    var regName = /^[a-zA-Z]+ [a-zA-Z]+$/;
    var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;        //https://stackoverflow.com/questions/201323/how-can-i-validate-an-email-address-using-a-regular-expression
    var emailregex = /^\S+@\S+\.\S+$/g;
    for (let i = 0; i < allFieldLabels.length; i++){

      if (fieldType[i] === "name"){
        if (form[allFieldLabels[i]].value === ""){
          error_texts.push("Please put in a name");
          form[allFieldLabels[i]].style.backgroundColor = "#fec925";
          form[allFieldLabels[i]].value = "";
          isValid = false;
        }
      }
      else if (fieldType[i] === "email"){
        if (!emailregex.test(form[allFieldLabels[i]].value)){
          error_texts.push("Use a proper email please");
          
          form[allFieldLabels[i]].style.backgroundColor = "#fec925";
          form[allFieldLabels[i]].value = "";
          isValid = false;
        }
      }
      else if (fieldType[i] === "phone"){
        if (!phoneno.test(form[allFieldLabels[i]].value)){
          error_texts.push("Use a proper phone number please");
          form[allFieldLabels[i]].style.backgroundColor = "#fec925";
          form[allFieldLabels[i]].value = "";
          isValid = false;
        }
      }
    }  
      var final_error_msg = "ERRORS: ";
      for(const element of error_texts) {
         final_error_msg += "\n" + element;
        }
      if(final_error_msg != "ERRORS: ")
      {
                alert(final_error_msg);
      }

      return isValid;      
    }
    </script>
<html>
    <head>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="css/contact.css">
        <link rel="stylesheet" href="https://use.typekit.net/tsz4xpq.css">
    </head>

    <body>
        <div class="container">

<!-- NAV --> 
    <?php include 'header.php'; //Header?>

<!-- PAGE CONTENT -->
<form name = "contactphp" action="contact_form.php" method="post" onsubmit="return(validate());">

            <div class="contactForm">
                <h1 class="title">Contact Us</h1>
                <h2 class="subtitle">You best have a good reason for it</h2>

                <div class="content-flexbox1">
                    <input type="text" id="fname" name="fname" placeholder="First Name"/> 
                    <input type="text" id="lname" name="lname" placeholder="Last Name">
                </div>
                
                <div class="content-flexbox2">
                    <input type ="text" id="email" name="email" placeholder="Email">  
                
                    <textarea id="subject" name="subject" placeholder="Write something . ."></textarea>

                    <div class="nested-content-flexbox2">
                        <label for="saveInfo" id="label_saveInfo">
                            <input type="checkbox" id="saveInfo"/>
                            Save information for later
                        </label>
                    </div>

                        <input class="submit" name="submitbutton" type="submit" value="Submit">
                </div>
            </div>
        
        </div> <!-- Container End -->
    </form>

<!-- FOOTER -->
    <?php include 'footer.php'; //Header?>

     </body>
</html>