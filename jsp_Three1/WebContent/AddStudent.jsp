<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudentServlet" method="post">
	<table border="1px">
		<tr>
			<td align="right">id：</td>
			<td><input type="number" name="id" class="uid"><br></td>
			<td><span >*用户id由7位数字组成</span></td>
		</tr>
		<tr>
			<td align="right">用户名：</td>
			<td><input type="text" name="name" class="uname" ><br></td>
			<td><span >*用户名由2~10位字符组成</span></td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<td><input type="radio" name="sex" value="男" id="sex" checked="checked">男  
			<input type="radio" name="sex" value="女" id="sex">女<br></td>
			<td><span>*请选择你的性别</span></td>
		</tr>
		<tr>
			<td align="right">出生日期：</td>
			<td><input type="date" name="date" class="udate" placeholder="年/月/日" ><br></td>
			<td><span >*请选择你的出生日期，格式为 -年-月-日</span></td>
		</tr> 		
		<tr>
			<td align="right">手机号码：</td>
			<td><input type="number" name="phone" class="uphone"><br></td>
			<td><span>*请输入11位电话号码</span></td>
		</tr>
		 <tr>
			<td align="right">电子邮件：</td>
			<td><input type="text" name="email" class="uemail"><br></td>
			<td><span> *请输入邮箱</span></td>
		</tr>
		<tr>
			<td align="right">住址：</td>
			<td><input type="text" name="address" class="uaddress" ><br></td>
			<td><span > *请输住址</span></td>
		</tr>
		<tr>
			<td align="right">自我介绍：</td>
			<td><textarea rows="6" cols="30" name="other" class="uother" placeholder="......"></textarea></td>
			<td><span>*限100字以内</span></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><br><input type="submit" value="提交" class="ok"></td>
		</tr>
	</table>
	</form>
	<a href="SeeAllStudentServlet">查看</a>
	<script type="text/javascript">
		var id = document.querySelector('.uid');
		var Name = document.querySelector('.uname');
		var date = document.querySelector('.udate');
		var phone = document.querySelector('.uphone');
		var email = document.querySelector('.uemail');
		var address = document.querySelector('.uaddress');
		var other = document.querySelector('.uother');	
		var regs =  /^[\u4e00-\u9fa5 ]{2,20}$/;	//中文
		var reg = /^[a-zA-Z\/ ]{2,20}$/;			//英文
		var emails = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
		
		var oNo = document.querySelector('.ok')
		oNo.onclick = function(){
			if(id.value.length!=7){
				alert("id");
				return false;
			}
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