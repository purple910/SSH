<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/9/20
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <s:form action="Validate">
        <s:textfield label="input name" name="entity.name"/>
        <s:submit value="Submit"/>
    </s:form>

    <br><br><br>

    <s:form action="register">
        <s:textfield label="input name" name="entity.name"/>
        <s:submit value="Submit"/>
    </s:form>
</body>
</html>
