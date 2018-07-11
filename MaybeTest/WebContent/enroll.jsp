<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'enroll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	function Check(){
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			var commit = document.getElementById("commit");
			if(username.value==""){
				document.getElementById("error_username").innerHTML = "用户名不能为空！";
				return false;
			}else if(password.value==""){
				document.getElementById("error_nickname").innerHTML = "";
				document.getElementById("error_password").innerHTML = "密码不能为空！";
				return false;
			}else if(password.value!=commit.value){
				document.getElementById("error_password").innerHTML = "";
				document.getElementById("error_commit").innerHTML = "密码和确认密码不一致！";
				return false;
			}
		}
	</script>

  </head>
  
  <body>
  <form method="post" onsubmit="return Check()" action="enrollControl.jsp">
  		<table border="0" align="center">
  			<tr>
  				<td>用户名：</td>
  				<td><input type="text" autocomplete="off" name="username" id="username" value=""
  							style="color: #000"></td>
  				<td><span id=error_username style="color:red"></span></td>
  			</tr>
  			<tr>
  				<td>密码：</td>
  				<td><input type="password" autocomplete="off" name="password" id="password" value=""
  							style="color: #000"></td>
  				<td><span id=error_password style="color:red"></span></td>
  			</tr>
  			<tr>
  				<td>重复密码：</td>
  				<td><input type="password" autocomplete="off" name="commit" id="commit" value=""
  							style="color: #000"></td>
  				<td><span id=error_commit style="color:red"></span></td>
  			</tr>
  			<tr>
  				<td>用户类型：</td>
  				<td><input type="radio" name="userpower" value="1">管理员</td>
  				<td><input type="radio" name="userpower" value="0" checked="checked">普通用户</td>
  			</tr>
  			<tr>
  				<td align="center">
  					<input type="submit" value="注册">
  					<input type="reset" value="取消" >
  					<a href="index.jsp"><input type="button" value="返回"></a>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
