<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/10/12
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container wrap">
    <form action="addOrder.action" method="post">
        <div class="input-group col-md-6 col-md-offset-3">
            <input type="text" style="display: none" name="orderEntity.id" value="${orderEntity.id}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
            <span class="input-group-addon">Ordername</span>
            <input type="text" class="form-control" placeholder="Ordername" name="orderEntity.name" value="${orderEntity.name}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
            <span class="input-group-addon">price</span>
            <input type="text" class="form-control" placeholder="price" name="orderEntity.price" value="${orderEntity.price}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
            <span class="input-group-addon">count</span>
            <input type="text" class="form-control" placeholder="count" name="orderEntity.count" value="${orderEntity.count}">
        </div>
            <div class="input-group col-md-6 col-md-offset-3">
                <select name="customEntity.id" class="btn bg-info ">
                    <s:iterator value="list" status="number">

                    <option value="<s:property value="id"/>"><s:property value="name"/></option>
                    </s:iterator>
                </select>
            </div>
        <div class="input-group col-md-6 col-md-offset-3">
            <input type="submit" class="btn btn-info" value="添加">
            <a class="btn btn-info" href="queryCustomAll.action">客户</a>
            <a class="btn btn-info" href="queryOrderAll.action">订单</a>
        </div>
    </form>
</div>
</body>
</html>
