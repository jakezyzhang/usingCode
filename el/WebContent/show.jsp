<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">     
    <title>显示</title>         
  <meta http-equiv="pragma" content="no-cache">  
  <meta http-equiv="cache-control" content="no-cache">  
  <meta http-equiv="expires" content="0">     
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
  <meta http-equiv="description" content="This is my page">  
 </head>  
 <body>  


<c:set var="someDateStr" value="2017-08-28"/>
<jsp:useBean id="nowDate" class="java.util.Date"/>
<fmt:parseDate var="someDate" value="${someDateStr}" pattern="yyyy-MM-dd"/>
<fmt:formatDate var="nowStr" value="${nowDate}" pattern="yyyy/MM/dd"/>
<c:set var="interval" value="${nowDate.time - someDate.time}"/>
<fmt:formatNumber value="${interval/1000/60/60/24/7}" pattern="#0"/>
 </body>  
</html>  