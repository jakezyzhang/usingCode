<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
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
    <title>发送信息验证</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
 <body>
<%request.setCharacterEncoding("UTF-8");
  String message = request.getParameter("sendmessage");	
  String regEx = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]{1,}"; 
  Pattern pattern = Pattern.compile(regEx);
  Matcher matcher = pattern.matcher(message);
  boolean rs = matcher.matches();
  
  if(message == null || message.equals("")){
	  request.setAttribute("message", "发送信息不能为空");
		request.getRequestDispatcher("sendMessage.jsp").forward(request,
				response);
  }else if(message.length()>70){
	  request.setAttribute("message", "发送的信息不能超过70 个字符");
		request.getRequestDispatcher("sendMessage.jsp").forward(request,
				response);
  }else if(rs==false){
	  request.setAttribute("message", "发送的信息必须含有@");
		request.getRequestDispatcher("sendMessage.jsp").forward(request,
				response);
		session.setAttribute("sendedmessage", message);
  }else{
	  response.sendRedirect("message.jsp");
  }
%>
 </body>
</html>