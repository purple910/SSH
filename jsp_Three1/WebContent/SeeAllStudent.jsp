<%@page import="java.util.Iterator"%>
<%@page import="com.factory.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		StringBuffer sb=new StringBuffer();
		ArrayList<StudentBean> result = (ArrayList<StudentBean>)request.getAttribute("result");
		if(result!=null){
			Iterator<StudentBean> it = result.iterator();
			while(it.hasNext()){
				StudentBean stu = it.next();
				sb.append("<tr><td>");
				sb.append(stu.getId());
				sb.append("</td><td>");
				sb.append(stu.getName());
				sb.append("</td><td>");
				sb.append(stu.getSex());
				sb.append("</td><td>");
				sb.append("<a href='DeleteStudentServlet?id="+stu.getId()+"'>删除</a>");
				sb.append("&nbsp");
				sb.append("<a href='SeeStudentServlet?id="+stu.getId()+"'>查看</a>");
				sb.append("</td></tr>");
			}
		}
	%>
	<form action="SeeStudentServlet">
		查询id:<input type="number" name="id" ><input type="submit" value="查看">
	</form>
	<table border="2px">
		 <thead>
			<tr>
				<td>id</td><td>用户名</td><td>性别</td><td>操作</td>
			</tr>
		  </thead>
		<tbody>
			<%out.append(sb); %>
		</tbody>	
	</table>	
	<a href="AddStudent.jsp">添加</a>
</body>
</html>