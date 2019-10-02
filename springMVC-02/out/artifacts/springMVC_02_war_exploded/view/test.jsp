<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    1 支持所有的get,post,put,delete
    2 可以将对象和表单绑定起来
--%>
<%--
    commandName,modelAttribute可以更改commnd
--%>
    <%--@elvariable id="people" type="com.company.entity.People"--%>
    <form:form commandName="people" >
        name: <form:input path="name"/><br>
        age: <form:input path="age"/><br>

        sex: <form:checkbox path="sex"/> <br>
        <form:checkboxes path="hobbis" items="${arrayList}"/><br>
        <form:checkboxes path="course" items="${hashMap}"/><br>
        <form:checkboxes items="${deptList}" path="depts" itemLabel="name" itemValue="id"/><br/>

        中国<form:radiobutton path="city" value="bj"/>
        美国<form:radiobutton path="city" value="us"/>
        西欧<form:radiobutton path="city" value="en"/><br>
        <form:radiobuttons path="home" items="${list}" delimiter=","/><br/>

        <form:select path="home" items="${list}"/><br>
        <form:select path="home">
            <form:option value="lu"/>
            <form:option value="bj"/>
            <form:option value="us"/>
            <form:option value="en"/>
        </form:select><br/>
        <form:select path="home">
            <form:options items="${list}"/>
        </form:select>

        <input type="submit" value="提交">
    </form:form>






    <form:form method="post" action="/FormController/testMenthod.form">
        <input type="submit" value="post">
    </form:form>

    <form:form method="get" action="/FormController/testMenthod.form">
        <input type="submit" value="get">
    </form:form>

    <form:form method="put" action="/FormController/testMenthod.form">
        <input type="submit" value="put">
    </form:form>

    <form:form method="delete" action="/FormController/testMenthod.form">
        <input type="submit" value="delete">
    </form:form>
</body>
</html>
