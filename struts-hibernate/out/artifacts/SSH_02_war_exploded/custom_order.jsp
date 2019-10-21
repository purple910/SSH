<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/10/12
  Time: 18:27
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

        <s:if test="temp==2">
            <table class="table table-bordered table-hover">
            <tr>
                <td>
                   id
                </td>
                <td>
                    name
                <td>
                <td>
                    price
                </td>
                <td>
                    count
                </td>
            </tr>
            <tr>
                <td>
                    ${orderEntity.id}
                </td>
                <td>
                    ${orderEntity.name}
                <td>
                <td>
                    ${orderEntity.price}
                </td>
                <td>
                    ${orderEntity.count}
                </td>
            </tr>
            </table>

            <table class="table table-bordered table-hover">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>ninkname</td>
                <td>address</td>
                <td>phone</td>
                <td>password</td>
            </tr>
            <tr>
                <td>
                ${customEntity.id}
                </td>
                <td>
                ${customEntity.name}
                </td>
                <td>
                ${customEntity.ninkname}
                </td>
                <td>
                ${customEntity.address}
                </td>
                <td>
                ${customEntity.phone}
                </td>
                <td>
                ${customEntity.passwork}
                </td>
            </tr>
            </table>
        </s:if>
        <s:else>
        <table class="table table-bordered table-hover">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>ninkname</td>
                <td>address</td>
                <td>phone</td>
                <td>password</td>
            </tr>
            <tr>
                <td>
                    ${customEntity.id}
                </td>
                <td>
                    ${customEntity.name}
                </td>
                <td>
                    ${customEntity.ninkname}
                </td>
                <td>
                    ${customEntity.address}
                </td>
                <td>
                    ${customEntity.phone}
                </td>
                <td>
                    ${customEntity.passwork}
                </td>
            </tr>
        </table>
        <table class="table table-bordered table-hover">
            <tr>
                <td>
                    id
                </td>
                <td>
                    name
                </td>
                <td>
                    price
                </td>
                <td>
                    count
                </td>
            </tr>
            <s:iterator value="list">
                <tr>
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
                </tr>
            </s:iterator>
        </table>
        </s:else>

        <a class="btn btn-info" href="queryCustomAll.action">客户</a>
        <a class="btn btn-info" href="queryOrderAll.action">订单</a>
    </div>


</body>
</html>
