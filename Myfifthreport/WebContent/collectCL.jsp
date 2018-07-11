<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zzy.register.dao.*" %>
<%@page import="com.zzy.register.dao.impl.*" %>
<%@page import="com.zzy.register.entity.*"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>处理收藏页面操作</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
 <body>
 	<%
 		request.setCharacterEncoding("UTF-8");
 		String webname = request.getParameter("webname");
 		String webaddress = request.getParameter("webaddress");
 		String label = request.getParameter("label");
 		String username = (String)session.getAttribute("username");
 		Collect collect = new Collect(webname, webaddress, label, username);
 		int result = new CollectDaoImpl().insert(collect);
 		if(result>0){
 			application.setAttribute("webName", webname);
 			application.setAttribute("webAddress", webaddress);
 			application.setAttribute("Label", label);
 			//application.setAttribute("userName", username);
 			response.sendRedirect("collect");
 		}
 		
 	%>
 </body>
</html>