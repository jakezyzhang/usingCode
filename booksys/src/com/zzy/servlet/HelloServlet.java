package com.zzy.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String context = req.getContextPath();
		System.out.println(context);
		System.out.println("Host:"+req.getHeader("Host"));
		Enumeration<String> enums = req.getHeaderNames();
		while(enums.hasMoreElements()){
			String en = enums.nextElement();
			System.out.println(en);
		}
		System.out.println("请求方法："+req.getMethod());
		String contexts = req.getContextPath();
		System.out.println("context:"+contexts);
		System.out.println("uri:"+req.getRequestURI());
		System.out.println("url:"+req.getRequestURL());
		System.out.println("ip:"+req.getRemoteAddr());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
