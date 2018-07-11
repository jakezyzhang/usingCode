<%@ page import="com.zzy.register.dao.util.*"%>
<%@ page import="com.zzy.register.entity.*"%>
<%@page import="com.zzy.register.dao.*" %>
<%@page import="com.zzy.register.dao.impl.*" %>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查看信息</title>
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
昵称为：<font><%=session.getAttribute("displayName") %></font>
	<%
		Page pages = (Page) request.getAttribute("pages");
		if (pages == null) {
			response.sendRedirect("pageControl.jsp?pageIndex=1");
		} else {
	%>
	<%
	
	//User user = new UserDaoImpl().findUserByName("admin");				
	//session.setAttribute("name", user.getName());
 	%>
 	<div><%//=session.getAttribute("name") %></div>
	<table border="1" cellpadding="0" cellspacing="0">
		<%
			int totalPages = pages.getTotalPageCount(); //总页数
			int pageIndex = pages.getCurrPageNo(); //当前页码
			for (News news : pages.getListNews()) {
		%>
		<tr>
			
			<td><a href="readNews.jsp?id=<%= news.getId() %>"><%=news.getTitle()%></a></td>
			<td><%=news.getCreateDate()%></td>
		</tr>
		<%
			}
		%>
	</table>
	当前页数：[<%=pageIndex%>/<%=totalPages%>]
		<%
			if (pageIndex > 1) { //如果当前不是第一页
		%>
				<a href="pageControl.jsp?pageIndex=1">首页</a>&nbsp;
				<a href="pageControl.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
		<%
			}
			if (pageIndex < totalPages) { //当前不是最后一页
		%>	
				<a href="pageControl.jsp?pageIndex=<%=pageIndex + 1%>">下一页</a>
				<a href="pageControl.jsp?pageIndex=<%=totalPages%>">末页</a>
		<%
			}
	}
	%>
	<input type="button" value="已发送消息" onclick="javascrtpt:window.location.href='sendedmessage.jsp'"/>
	<input type="button" value="我要发送消息" onclick="javascrtpt:window.location.href='sendMessage.jsp'"/>
	
</body>
</html>
