<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tanyamei.biz.*" %>
<%@ page import="tanyamei.biz.impl.*" %>
<%@ page import="tanyamei.dao.*" %>
<%@ page import="tanyamei.dao.impl.*" %> 
<%@ page import="tanyamei.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    String login_username = null;
  	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i = 0; i<cookies.length; i++){
			if(cookies[i].getName().equals("loging_username") == true){
				login_username = cookies[i].getValue();
				login_username = URLDecoder.decode(login_username,"gbk");
				break;
			}
		}
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'common.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	function click_button(){
		var username = <%=login_username%>;
		if(username == null){
			alert("用户未登录！请登录后操作！");
			location.href="index.jsp";
			return false;
		}
	}
	</script>
  </head>
  
  <body>
  	<p>用户未投票项：</p>
  	<%
  		List<Vote> list1 = new ArrayList<Vote>();
  		list1 = new User_VoteDaoImpl().select_notdo(login_username);
  		for(Vote l:list1){
  	%>
  		<%=l.getVote_id() %>.<%=l.getVote_title() %><br>
  		<input type="radio" name="choice">1.<%=l.getChoices()[0] %>
  		<input type="radio" name="choice">2.<%=l.getChoices()[1] %>
  		<input type="radio" name="choice">3.<%=l.getChoices()[2] %><br>
  		<br>
  	<%
  		}
  	%>
  	<p>用户已投票项：</p>
  	<%
  		List<Vote> list2 = new ArrayList<Vote>();
  		list2 = new User_VoteDaoImpl().select_do(login_username);
		for(Vote i:list1){
	%>
		<%=i.getVote_id() %>.<%=i.getVote_title() %><br>
		<input type="radio" name="choice">1.<%=i.getChoices()[0] %>
		<input type="radio" name="choice">2.<%=i.getChoices()[1] %>
		<input type="radio" name="choice">3.<%=i.getChoices()[2] %><br>
		<br>
	<%
		}
  	%>
  </body>
</html>
