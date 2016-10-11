<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UploadFiles</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

    <div class="custom-file-upload">
        <form method="post" enctype="multipart/form-data" action="rest/multipleSave">
            Upload File 1: <input type="file" name="file"> <br/>
            Upload File 2: <input type="file" name="file"> <br/>
            Upload File 3: <input type="file" name="file"> <br/>
            Upload File 4: <input type="file" name="file"> <br/>
            <br /><br /><input type="submit" value="Upload">
       </form>
    </div>

</body>
</html>
