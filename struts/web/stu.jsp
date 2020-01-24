<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/9/13
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <s:iterator value="list" status="num">
        <tr>
            <td>
                <s:property value="#num.index"/>
                <s:property value="#num.count"/>
                <s:property value="name"/>
                <s:property value="password"/>

            </td>
            <br>
        </tr>
    </s:iterator>
</body>
</html>
