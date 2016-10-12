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
        <form method="post" enctype="multipart/form-data" action="rest/multipleSave" id="formUploadFile">
            Upload File: <input type="file" name="file"> <br/>
            Upload File: <input type="file" name="file"> <br/>
            Upload File: <input type="file" name="file"> <br/>
            <br/><br/><input type="submit" value="Upload">
       </form>
        <br/>
        <input type="button" class="addFileField" value="Add Field 'Upload File'">
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="resources/script/script.js"></script>
</body>
</html>
