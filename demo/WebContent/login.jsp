<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
  <%
	  Integer count = (Integer)application.getAttribute("count");
	  if(count !=  null){
		  count = 1 + count;
	  }else{
		  count = 1;	 	
	  }
	  application.setAttribute("count",count);
%>
 <body>
	<%
		//获取验证消息
		request.setCharacterEncoding("UTF-8");
		String message = (String) request.getAttribute("message");
	%>
 	<form action="loginCL.jsp"method="post">
 		<table border="0px" align="center">
 			
 				<tr height="30px">
 					<td>用户名：</td>
 					<td><input type="text" name="username"/><span style="color: red;position: absolute;left: 830px"><%=message != null && !message.equals("")?message:"" %></span></td>
 				</tr>
 				<tr height="30px">
 					<td>密&nbsp;&nbsp;&nbsp;码：</td>
 					<td><input type="password" name="password"/></td>
 				</tr>
 				<tr height="30px" >
 					<td align="right"><input type="submit" value="登陆"/></td>
 					<td align="center"><input type="button"  value="退出" onclick="javascrtpt:window.location.href='login.jsp'"/></td>
 			
 				</tr>
 			
 		</table>
 	</form>
 </body>
</html>