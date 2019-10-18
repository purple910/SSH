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
        <table class="table table-bordered table-hover">

            <tr>
                <td>id</td>
                <td>name</td>
                <td>ninkname</td>
                <td>password</td>
                <td>phone</td>
                <td>addresss</td>
                <td>操作</td>
                <td>查询</td>
                <td>查询订单</td>
                <td>添加订单</td>
            </tr>

        <s:iterator value="list" status="number">
            <tr>
                <td >
                    <s:property value="id"/>
                </td>
                <td>
                    <s:property value="name"/>
                </td>
                <td>
                    <s:property value="ninkname"/>
                </td>
                <td>
                    <s:property value="passwork"/>
                </td>
                <td>
                    <s:property value="address"/>
                </td>
                <td>
                    <s:property value="phone"/>
                </td>
                <td>
                    <a class="btn btn-default delete" href="deleteCustom.action?customEntity.id=${id}">删除</a>
                </td>
                <td>
                    <a class="btn btn-default query" href="queryCustomInfo.action?customEntity.id=${id}">查询</a>
                </td>
                <td>
                    <a class="btn btn-default query" href="queryOrderByCustomer.action?customEntity.id=${id}">查询订单</a>
                </td>
                <td>
                    <a class="btn btn-default" href="queryCustomAll.action?customEntity.id=${id}&temp=1">添加订单</a>
                </td>
            </tr>
        </s:iterator>

        </table>

        <a class="btn btn-info" href="index.jsp">添加客户</a>
        <a class="btn btn-info" href="queryOrderAll.action">订单</a>
    </div>



</body>
</html>
