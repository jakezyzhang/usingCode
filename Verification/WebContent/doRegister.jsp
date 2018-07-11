<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%
  	
  		String captcha = request.getParameter("captcha");
  		String sessionCaptcha = (String)session.getAttribute("captcha");
  		
  		if(!captcha.equals(sessionCaptcha)) {
  			request.setAttribute("message", "验证码输入错误，请重新填写");
  			request.getRequestDispatcher("register.jsp").forward(request, response);
  		
  			return;
  		}
  		
  		out.println("注册码填写正确！");
  	%>
  </body>
</html>
