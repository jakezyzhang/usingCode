<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tanyamei.biz.*" %>
<%@ page import="tanyamei.biz.impl.*" %>
<%@ page import="tanyamei.dao.*" %>
<%@ page import="tanyamei.dao.impl.*" %>
<%@ page import="tanyamei.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'enrollControl.jsp' starting page</title>
    
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
  		request.setCharacterEncoding("UTF-8");
  		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		int userpower = Integer.parseInt(request.getParameter("userpower"));
		User user = new UserDaoImpl().findUserByUsername(username);
		if(user != null){
	 %>
		  	用户名已存在成功！<a href="index.jsp">登录</a>&nbsp;&nbsp;<a href="enroll.jsp">重新注册</a>
	 <%
		}else{
			User newuser = new User(username,password,userpower);
	  		int res = new UserDaoImpl().insert(newuser);
	  		if (res > 0) {
	  %>
	  		用户注册成功！<a href="index.jsp">登录</a>
	  <%
			} else {
	  %>
		  	用户注册失败！<a href="enroll.jsp">重新注册</a>
	  <%
			}
		}
		response.sendRedirect("enroll.jsp");
  	%>
  </body>
</html>
