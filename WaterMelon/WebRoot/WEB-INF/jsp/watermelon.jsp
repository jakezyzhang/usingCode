<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点击短链接跳转到长链接</title>
 <%
	  Integer count = (Integer)application.getAttribute("count");
	  if(count !=  null){
		  count = 1 + count;
	  }else{
		  count = 1;	 	
	  }
	  application.setAttribute("count",count);
%>
</head>
<body>
<form action="${pageContext.request.contextPath }/shortLink.action" method="post">
	<table style="margin:0px auto">
		<tr>
			<td ><input type="text" name="linklong"/></td>
			<td ><input type="submit" value="转换成短链接"/></td>
			<td><font style="color:red">${requestScope.mistake }</font></td>
		</tr>
	</table>
	
</form>
</body>
</html>