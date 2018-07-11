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
    <title>列表</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$('#btn').click(function () {
			$.post("list",function(data){
				//var da = [{id:1,name:'java',author:'sun',price:55.5},
					//{id:2,name:'c#',author:'Microsoft',price:45.5},
					//{id:1,name:'c++',author:'Microsoft',price:35.5},
					//{id:1,name:'.net',author:'Microsoft',price:65.5}]
				//eval("var da={id:1,name:'java',author:'sun',price:55.5}");
				//var da = eval("("+"[{id:1,name:'java',author:'sun',price:55.5},{id:2,name:'c#',author:'Microsoft',price:45.5}]"+")");
				var da = data;
				var html = "";
				for(var i=0;i<da.length;i++){
					html+="<tr><td>"+da[i].id+"</td><td>"+da[i].name+"</td><td>"+da[i].author+"</td><td>"+da[i].price+"</td></tr>";
				}
				$('#mytable').html(html);
			},'json');
		});
  	});
  </script>	
 </head>
 <body>
 	<input type="button" id="btn" value="获取数据" />
 	<table id="mytable" width="80%" align="center"></table>
 </body>
</html>