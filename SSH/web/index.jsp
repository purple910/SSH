<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fate
  Date: 2019/10/4
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="add.action" method="post">
    id:<input name="bookCard.cid">
    name:<input name="bookCard.name">
    sex:<input name="bookCard.sex">
    cardDate:<input name="bookCard.cardDate" type="date">
    <input type="submit" value="add">
  </form>



  <table border="1">
    <tr>
      <td>卡号</td>
      <td>姓名</td>
      <td>性别</td>
      <td>办卡日期</td>
    </tr>
    <!-- 使用struts2标签库中的iterator将所有数据遍历循环显示出来 -->

    <s:iterator value="#myBookCardList" status="bcs">
      <tr>
        <td><s:property value="cid"></s:property></td>
        <td><s:property value="name"></s:property></td>
        <td><s:property value="sex"></s:property></td>
        <td><s:date name="cardDate" format="yyyy年MM月dd日"></s:date></td>
      </tr>
    </s:iterator>
    <!-- 判断查询出来等于0，就显示“没有查找到数据” -->
    <s:if test="myBookCardList.size()==0">
      <tr>
        <td colspan="7">没有查找到数据</td>
      </tr>
    </s:if>
  </table>
  </body>
</html>
