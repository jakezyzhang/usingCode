<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vote_submit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	function Check(){
		var title = document.getElementById("title");
		var choice = document.getElementsByName("choice");
		document.getElementById("error").innerHTML = "";
		if(title.value==""){
			document.getElementById("error").innerHTML = "投票问题不能为空！";
			return false;
		}else if(choice[0].value==""){
			document.getElementById("error").innerHTML = "选项一不能为空！";
			return false;
		}else if(choice[1].value==""){
			document.getElementById("error").innerHTML = "选项一不能为空！";
			return false;
		}else if(choice[2].value==""){
			document.getElementById("error").innerHTML = "选项一不能为空！";
			return false;
		}
	}
	</script>

  </head>
  
  <body>
  	<form method="post" action="voteControl.jsp" onsubmit="return Check()">
	  	<table>
	  		<tr><td>投票问题：<input type="text" id="title"></td></tr>
	  		<tr><td>选项一：<input type="text" name="choice"></td></tr>
	  		<tr><td>选项二：<input type="text" name="choice"></td></tr>
	  		<tr><td>选项三：<input type="text" name="choice"></td></tr>
	  		<tr><td><input type="submit" value="提交"></td></tr>
	  		<tr><td><span id=error style="color:red"></span></td></tr>
	  	</table>
  	</form>
  </body>
</html>
