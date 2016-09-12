<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
    <h1>Upload any image to mysql DB</h1>
    <form method="post" action="fileUpload"
        enctype="multipart/form-data">
        <table>
            <tr>
                <td>Choose Image:</td>
                <td><input type="file" name="file" size="10"
                    required="required" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
                <td><input type="reset" value="Clear" /></td>
            </tr>
        </table>
    </form>
</body>
</html>