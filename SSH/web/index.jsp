<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/10/12
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <style type="text/css">
      .wrap{
        margin-top: 100px;
      }
    </style>
  </head>
  <body>
    <div class="container wrap">
      <form action="addCustom.action" method="post">
        <div class="input-group col-md-6 col-md-offset-3">
          <input type="text" style="display: none" name="customEntity.id" value="${customEntity.id}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
          <span class="input-group-addon">Username</span>
          <input type="text" class="form-control" placeholder="Username" name="customEntity.name" value="${customEntity.name}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
          <span class="input-group-addon">ninkname</span>
          <input type="text" class="form-control" placeholder="ninkname" name="customEntity.ninkname" value="${customEntity.ninkname}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
          <span class="input-group-addon">password</span>
          <input type="text" class="form-control" placeholder="passwd" name="customEntity.passwork" value="${customEntity.passwork}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
          <span class="input-group-addon">phone</span>
          <input type="text" class="form-control" placeholder="phone" name="customEntity.phone" value="${customEntity.phone}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
          <span class="input-group-addon">address</span>
          <input type="text" class="form-control" placeholder="address" name="customEntity.address" value="${customEntity.address}">
        </div>
        <div class="input-group col-md-6 col-md-offset-3">
         <input type="submit" class="btn btn-info" value="添加">
          <a class="btn btn-info" href="queryCustomAll.action">查看</a>
        </div>
      </form>

    </div>
  </body>
</html>
