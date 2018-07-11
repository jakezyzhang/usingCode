<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@ page import="com.rainsia.news.dao.util.*"%>
<%@ page import="com.rainsia.news.entity.*"%>
<%@page import="com.rainsia.news.dao.*" %>
<%@page import="com.rainsia.news.dao.impl.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册处理页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String validatepwd = request.getParameter("validatepwd");
		String displayname = request.getParameter("displayName");
		String mail = request.getParameter("email");
		String person = request.getParameter("person");
		String x = request.getParameter("role");
		int role = Integer.parseInt(x);
		String regEx = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(mail);
		    // 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		if (name == null || name.equals("")) {
			request.setAttribute("message", "用户名不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (pwd == null || pwd.equals("")) {
			request.setAttribute("message", "密码不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (!validatepwd.equals(pwd)) {
			request.setAttribute("message", "两次输入的密码不一致");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}else if(displayname == null || displayname.equals("")) {
			request.setAttribute("message", "显示名不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}else if(rs == false){
			request.setAttribute("message", "email输入格式不对");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}else if(person == null || person.equals("")){
			request.setAttribute("message", "个人简介不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}
		else {
			int count = new UserDaoImpl().countUserByName(name);
			if(count >= 1) {
				request.setAttribute("message", "用户已存在，请重新注册!");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			} else {
				User newUser = new User(name, displayname, pwd, role);

				int result = new UserDaoImpl().insert(newUser);
				if (result > 0) {
					out.println("<script type='text/javascript'>"
							+ "alert('注册成功！马上登录。');"
							+ "location.href='login.jsp';"
							+ "</script>");
					session.setAttribute("displayName", displayname);
					//response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("message", "注册失败，请重新注册。");
					request.getRequestDispatcher("register.jsp").forward(
							request, response);
				}
			}
		}
	%>
</body>
</html>
