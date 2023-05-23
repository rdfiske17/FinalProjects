<!DOCTYPE html> <! https://www.youtube.com/watch?v=EEfXGYxIegA >
<html>
    <head>
        <link rel="stylesheet" href="../css/master.css">
    </head>
        <body>

        <?php
            $filename = $_FILES['file']['name'];
            $location = "../images/" . $filename;

            if( move_uploaded_file($_FILES['file']['tmp_name'],$location)) {
                echo "File upload completed!";
            }
            else {
                echo "Error uploading file.";
            }
        ?>
        <input type="button" id="prev_page" value="Go Back" onclick="location.href='admin_product_image_upload.php'">
    </body>
</html>        