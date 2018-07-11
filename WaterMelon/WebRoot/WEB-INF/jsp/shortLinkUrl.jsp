<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>长链接转换成短链接</title>


<%
	  Integer i = (Integer)application.getAttribute("count");
	  out.println("您好，您是第 " + i +" 位访问本网站的用户" );
%>


<script type="text/javascript">
function display_alert()
  {
  alert("正在访问${requestScope.LinkLongUrl }")
  }
</script>

</head>
<body >

<table style="margin:0px auto">
 <tr>
 	<td>
 		<font>根据长链接生成的短链接</font>
 	</td>
 </tr>
 </table>
 <table style="margin:0px auto">
  <tr>
 	<td>
		<a  href="http://${requestScope.LinkLongUrl }" name="linkshort"  onclick="display_alert()">${requestScope.shortUrl }</a>
 		
 	</td>
  </tr>
</table>
<table style="margin:0px auto">
<c:forEach items="${findLinkShortUrl }" var="link">
<tr>
	<td><a href="http://${requestScope.LinkLongUrl }" name="linkshort" onclick="display_alert()">${link.linkshort }</a></td>
</tr>
</c:forEach>
</table> 
<table style="margin:0px auto">
	<tr>
		<td><a href="${pageContext.request.contextPath }/queryLink.action">返回</a></td>
	</tr>
</table>
</body>
</html>