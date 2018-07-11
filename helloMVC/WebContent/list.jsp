<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
 <body>
 	<table width="80%" align="center">
 		<tr>
 			<td>编号</td>
 			<td>名称</td>
 			<td>价格 </td>
 			<td>作者</td>
 		</tr>
 		<c:forEach items="${list }" var="bean">
 		<tr>
 			<td>${bean.id }</td>
 			<td>${bean.name }</td>
 			<td><fmt:formatNumber value="${bean.price }" type="currency"></fmt:formatNumber> </td>
 			<td>${bean.author }</td>
 		</tr>
 		</c:forEach>
 	</table>
 	<font>${message }</font>
 </body>
</html>