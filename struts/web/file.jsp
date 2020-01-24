<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/9/13
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="upload.action" method="post" enctype="multipart/form-data">
        <input type="file" name="file"><br>
        <input type="submit" value="upload">
    </form>
    <a href="download.action">1.jpg</a>
</body>
</html>
