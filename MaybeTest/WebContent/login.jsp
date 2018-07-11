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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
  <%
  	 String username = request.getParameter("username");
	 String password = request.getParameter("password");
	 LoginBiz loginbiz = new LoginBizImpl();
	 User user = loginbiz.login(username, password);
	 if(user == null){
	%>
	                 用户不存在或密码输入错误！！！<a href="index.jsp">重新登录</a>
	<%
	 }else{
		 Cookie cookie_username = new Cookie("loging_username",username);
		 cookie_username.setMaxAge(5*60);
		 response.addCookie(cookie_username);
		 if(user.getUserpower()==1){ //管理员
			 response.sendRedirect("manager.jsp");
		 }else{//普通用户
			 response.sendRedirect("common.jsp");
		 }
	 }
  %>
  </body>
</html>
