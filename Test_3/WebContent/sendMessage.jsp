<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript" src="js/app.js"></script>
 </head>
 <body>
 <form action="getmessage.action" method="post">
 	<table>
 		<tr>
 			<td>发送对象：</td>
 			<td>
 				<select  style="font-family:Verdana, Arial, Helvetica, sans-serif;"  onchange="showMessage(this.value)">
 					<option >请选择</option>
 					<c:forEach items="${userList }" var="user" >
 						<option >${user.username }</option>
 					</c:forEach>
 				</select>
 			</td>
 		</tr>
 		<tr>
 			<td>内容</td>
 			<td><input type="text" style="width:300px;height:300px" name="messageLabel"/></td>
 		</tr>
 		<tr>
 			<td></td>
 			
 			<td><input type="submit" value="发送" /></td>
 		</tr>
 	</table>
 	</form>
 </body>
</html>