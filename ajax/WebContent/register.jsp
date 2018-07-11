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
    <title>注册</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <script>
  	$(function() {
		$('input[name=username]').blur(function() {
			$.post("register",{username:$('input[name=username]').val()},function(data){
				if('true'==data){
					$('input[name=username]').css('border', '1px solid red');
					
				}else{
					$('input[name=username]').css('border','1px solid green');
				}
			});
		});
	});
  </script>
 </head>
 <body>
 	<form action="register" method="post">
 		用户名：<input type="text" name="username" />
 	</form>
 </body>
</html>