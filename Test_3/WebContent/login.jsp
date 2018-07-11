<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="java.text.ParseException"%>
<%@page import="org.omg.CORBA.PUBLIC_MEMBER"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
 <body>
 	<form action="login" method="post">
 		<table border="0px" align="center">
 			
 				<tr height="30px">
 					<td>用户名: </td>
 					<td><input type="text" name="username" value="${sessionScope.remembername}"/><span style="color: red;position: absolute;left: 830px">${requestScope.message != null && requestScope.message ne ""?requestScope.message:"" }</span></td>
 				</tr>
 				<tr height="30px">
 					<td>密&nbsp;&nbsp;&nbsp;码：</td>
 					<td><input type="password" name="password"/></td>
 				</tr>
 				
 				<tr height="30px" >
 					<td align="right"><input type="submit" value="登陆"/></td>
 					<td align="center"><input type="button"  value="退出" onclick="javascrtpt:window.location.href='index.jsp'"/></td>
 					<td ><input type="button" value="注册" onclick="javascrtpt:window.location.href='register.jsp'"/></td>
 					
 				</tr>
 			
 		</table>
 		
 	</form>
 </body>
</html>