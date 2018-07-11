<%@page import="tanyamei.dao.impl.VoteDaoImpl"%>
<%@page import="tanyamei.dao.VoteDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="tanyamei.entity.Vote" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>voteControl.jsp</title>
    
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
  			String title = request.getParameter("title");
  			String[] choices = request.getParameterValues("choice");
  			Vote v = new Vote(title,choices);
  			new VoteDaoImpl().insert(v);
  			response.sendRedirect("index.jsp");
  		%>
  </body>
</html>
