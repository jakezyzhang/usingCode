<%@ page import="com.rainsia.news.dao.impl.*" %>
<%@ page import="com.rainsia.news.dao.*" %>
<%@ page import="com.rainsia.news.dao.util.*" %>
<%@ page import="com.rainsia.news.entity.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String strId = request.getParameter("id");
	int id = Integer.valueOf(strId);
    NewsDao newsDao = new NewsDaoImpl();
    News news = newsDao.getNewsById(id);

%>

<table>
	<tr>
		<td><%= news.getTitle() %></td>
	</tr>
	<tr>
		<td><%= news.getAuthor()%> &nbsp; <%= news.getCreateDate() %></td>
	</tr>
	<tr>
		<%= news.getContent() %>
	</tr>
</table>

</body>
</html>