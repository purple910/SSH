<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'CommonUpload.jsp' starting page</title>
</head>
<body>
		<form action="CommonUpload.do" enctype="multipart/form-data" method="post">
			学号:<input name="name"><br>
			上传图片：<input type="file" name="Upload" /><br>
			<input type="submit" value="上传" />
		</form>
		<a href="Download?filename=1.png">1.png</a>
	</body>
</html>
