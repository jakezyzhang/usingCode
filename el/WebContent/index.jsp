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
 </head>  
 <body>  
   	<form action="show.jsp" method="post">
   		用户名：<input type="text" name="username"/><br />
   		密码<input type="password" name="password"/>
   		爱好<input type="checkbox" name="hobbies" value="football" />football
   		<input type="checkbox" name="hobbies" value="basketball" />basketball
   		<input type="checkbox" name="hobbies" value="vollyball" />vollyball
   		<input type="submit" value="提交"/>
   	</form>
 </body>  
</html>  