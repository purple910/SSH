<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!--国际化操作-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<fmt:message key="resouce.exist"/>
		<fmt:message key="resouce.welcome"/>
	</h3>

	<hr/>
	${student1.name}
	${student1.id}
	${requestScope.student1.age}
	<hr/>
	${student2.name}
	${student2.id}
	${requestScope.student2.age}
	<hr/>
	${student3.name}
	${student3.id}
	${requestScope.student3.age}
	<hr>
	${student4.name}
	${student4.id}
	${requestScope.student4.age}
	<hr>
	${student4.name}
	${student4.id}
	${sessionScope.student4.age}

	${student.name}
	${student.id}
	${student.age}
	<hr>
	<img src="../img/2.jpg" width="100">
</body>
</html>