<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	Object obj = request.getParameter("agreeb");
 	if(obj==null){//没有登录
 		response.sendRedirect("index.jsp");
 	}
 %>