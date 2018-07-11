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
    <title>发送消息</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
 <body>
 
 	<h3>发送消息</h3>
 <form action="sendMessageCL.jsp"method="post" >
  <textarea name="sendmessage" id="" cols="70	" rows="10"></textarea><span style="color: red;font-weight: bold;position: absolute;left: 830px"><%=request.getAttribute("message")!=null?request.getAttribute("message"):"" %></span>
				</br>
 <input type="submit" value="发送消息"/>
 <input type="button" value="退出" onclick="javascrtpt:window.location.href='login.jsp'"/>
 </form>
 </body>
</html>