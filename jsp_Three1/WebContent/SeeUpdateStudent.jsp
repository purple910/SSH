<%@page import="com.factory.StudentBean"%>
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
		StudentBean stu = (StudentBean)request.getAttribute("stu");
	%>
	<form action="UpdateStudentServlet" method="post">
	<table border="1px">
		<tr>
			<td align="right">id：</td>
			<td><input  name="id" value="<%=stu.getId()%>" readonly="readonly"><br></td>
		</tr>
		<tr>
			<td align="right">用户名：</td>
			<td><input type="text" name="name" class="uname" value="<%=stu.getName()%>"><br></td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<%
				if(stu.getSex().equals("男")){
			%>
			<td><input type="radio" name="sex" value="男" id="sex" checked="checked">男  
			<input type="radio" name="sex" value="女" id="sex">女<br></td>
			<%
				}
				else{
			%>
			<td><input type="radio" name="sex" value="男" id="sex" >男  
			<input type="radio" name="sex" value="女" id="sex" checked="checked">女<br></td>
			<%} %>
		</tr>
		<tr>
			<td align="right">出生日期：</td>
			<td><input type="text" name="date" class="udate" value="<%=stu.getDate()%>"><br></td>
		</tr> 		
		<tr>
			<td align="right">手机号码：</td>
			<td><input type="number" name="phone" class="uphone" value="<%=stu.getPhone()%>"><br></td>
		</tr>
		 <tr>
			<td align="right">电子邮件：</td>
			<td><input type="text" name="email" class="uemail" value="<%=stu.getEmail()%>"><br></td>
		</tr>
		<tr>
			<td align="right">住址：</td>
			<td><input type="text" name="address" class="uaddress" value="<%=stu.getAddress()%>"><br></td>
		</tr>
		<tr>
			<td align="right">自我介绍：</td>
			<td><textarea rows="6" cols="30" name="other" class="uother" ><%=stu.getOther()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br><input type="submit" value="修改" class="ok"></td>
		</tr>
	</table>
	</form>
	<a href="SeeAllStudentServlet">返回</a>
	<script type="text/javascript">
		var Name = document.querySelector('.uname');
		var date = document.querySelector('.udate');
		var phone = document.querySelector('.uphone');
		var email = document.querySelector('.uemail');
		var address = document.querySelector('.uaddress');
		var other = document.querySelector('.uother');	
		var regs =  /^[\u4e00-\u9fa5 ]{2,20}$/;	//中文
		var reg = /^[a-zA-Z\/ ]{2,20}$/;			//英文
		var emails = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
		var oOk= document.querySelector('.ok')
		oOk.onclick = function(){
			if(Name.value.length==0){
				alert("name");
				return false;
			}else{
				if((!reg.test(Name.value))&&(!regs.test(Name.value))){  
					alert("name");
					return false;
				}
			}
			if(date.value==null||date.value==""){
				alert("date");
				return false;
			}
			if(phone.value.length!=11){
				alert("phone");
				return false;
			}
			if(!emails.test(email.value)){
				alert("email");
				return false;
			}
			if(address.value!=""||address.value!=null){
				var reg1 = RegExp(/省/);
				var reg2 = RegExp(/市/);
				var reg3 = RegExp(/自治区/);
				var reg3 = RegExp(/区/);
				var reg4 = RegExp(/县/);
				if(!reg1.test(address.value)){//省
					if((!reg2.test(address.value))&&(!reg3.test(address.value))){//市,自治区
						alert("没有市或自治区");
						return false;
					}
					else{
						if((!reg3.test(address.value))&&(!reg4.test(address.value))){
							alert("没有区或县");
							return false;
						}
					}
				}
				else{
					if(!reg2.test(address.value)){
						alert("没有市");
						return false;
					}
					else{
						if((!reg3.test(address.value))&&(!reg4.test(address.value))){
							alert("没有区或县");
							return false;
						}
					}
				}

			}
			if(other.value.length>100){
				alert("other");
				return false;
			}
			return true;
		}	
</script>
</body>
</html>