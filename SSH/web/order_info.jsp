<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/10/12
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container wrap">

        <table class="table-hover table table-bordered">
            <tr>
                <td>编号</td>
                <td>id</td>
                <td>name</td>
                <td>price</td>
                <td>count</td>
                <td>操作</td>
                <td>操作</td>
                <td>操作</td>
            </tr>
            <s:iterator value="list" status="num">
            <tr>
                <td>
                    <s:property value="#num.index"/>
                </td>
                <td>
                    <s:property value="id"/>
                </td>
                <td>
                    <s:property value="name"/>
                </td>
                <td>
                    <s:property value="price"/>
                </td>
                <td>
                    <s:property value="count"/>
                </td>
                <td>
                    <a class="btn btn-default" href="queryOrderInfo.action?orderEntity.id=${id}">查看</a>
                </td>
                <td>
                    <a class="btn btn-default" href="queryCustomByOrder.action?orderEntity.id=${id}">查看客户</a>
                </td>
                <td>
                    <a class="btn btn-default" href="deleteOrder.action?orderEntity.id=${id}">删除</a>
                </td>
            </tr>
        </s:iterator>
        </table>
        <a class="btn-info btn" href="queryCustomAll.action?temp=1">添加订单</a>
        <a class="btn btn-info" href="queryCustomAll.action">客户</a>
    </div>

</body>
</html>
