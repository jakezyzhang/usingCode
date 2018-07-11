package com.zzy.test.servlet;

import java.io.IOException;


import com.zzy.test.*;
import com.zzy.test.entity.*;

import com.zzy.test.dao.*;
import com.zzy.test.dao.mysql.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");

		HttpSession session = req.getSession();


		
		if(name == null || pwd == null) {
			req.setAttribute("message", "未输入用户名或者密码！");
			req.getRequestDispatcher("login.jsp").forward(
				req, resp);
		} else if(name.trim().isEmpty() || pwd.trim().isEmpty()) {
			req.setAttribute("message", "未输入用户名或者密码！");
			req.getRequestDispatcher("login.jsp").forward(
				req, resp);
		} else {
			User user = new UserDaoImpl().findUserByName(name);
			if(user == null || !user.getPassword().equals(pwd)) {
				req.setAttribute("message", "用户名或密码错误，请重新登录！");
				req.getRequestDispatcher("login.jsp").forward(
					req, resp);
			} else {

				session.setAttribute("username", name);
				session.setAttribute("userName", name);
				
				resp.sendRedirect("message.jsp");
			}
		}
	}
}
