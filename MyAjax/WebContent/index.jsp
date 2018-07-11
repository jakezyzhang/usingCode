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

	省份：<select style="font-family:Verdana, Arial, Helvetica, sans-serif;"  onchange="showCustomer(this.value)">
 			<option>请选择</option>
 			<c:forEach items="${provList }" var="prov">
 				
 				<option >${prov.provName }</option>
 			</c:forEach>
 		</select>
      城市：<select name="" id="txtHint" onchange="showCustomer2(this.value)">
 			<c:forEach items="${city }" var="city"> 
				<option >${city.cityName }</option>
			</c:forEach>
		</select>
     区域：<select name="" id="txtHint2" onchange="showCustomer3(this.value)">
 			<c:forEach items="${dist }" var="dist" > 
				<option >${dist.distName }</option>
			</c:forEach>
		</select>
		<a href="getDetail.action">提交</a>	
 </body>
</html>