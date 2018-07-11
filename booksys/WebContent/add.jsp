<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 </head>
<body>
	<form action="book?op=add" method="post">
		<table width="80%" align="center">
			<tr>
				<td colspan="2"><h3>添加书籍</h3></td>
				
			</tr>
			<tr>
				<td>书名：</td>
				<td><input type="text" name="name"></input></td>
			</tr>
			<tr>
				<td>分类：</td>
				<td>
					<select name="categoryId">
						<c:forEach items="${clist }" var="bean">
							<option value="${bean.id }">${bean.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>价格：</td>
				<td><input type="text" name="price"></input></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><input type="text" name="author"></input></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>