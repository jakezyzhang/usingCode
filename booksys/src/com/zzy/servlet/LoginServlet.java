package com.zzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String remember = req.getParameter("remember");
		if("1".equals(remember)){
			Cookie ck = new Cookie("username", name);
			//Cookie ck1 = new Cookie("password",pwd);
			ck.setMaxAge(2*7*24*3600);
			//ck1.setMaxAge(2*7*24*3600);
			resp.addCookie(ck);
			//resp.addCookie(ck1);
		}
		HttpSession session = req.getSession();
		session.setAttribute("username", name);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
