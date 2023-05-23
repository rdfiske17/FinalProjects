<!DOCTYPE html> <! https://www.youtube.com/watch?v=EEfXGYxIegA >
<html>
    <head>
        <link rel="stylesheet" href="../css/master.css">
        <title> File Upload </title>
    </head>

    <body>
        <p> Please note that the exact filename the image is uploaded with is the one you must reference <br /> when adding a new product to the page.
        <form action="admin_product_image_upload_redirect.php" method="post" enctype="multipart/form-data">
            <input type="file" name="file" />
            <input type = "submit" value = "Upload" />
        </form>
        <input type="button" id="prev_page" value="Product Admin Home" onclick="location.href='admin_product_list.php'">
    </body>
</html>