package com.zzy.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class ContextServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		ServletContext servletContext = this.getServletContext();
//		ServletContext servletContext1 = req.getSession().getServletContext();
//		servletContext.setAttribute("count", 1);
//		servletContext.getAttribute("count");
//		servletContext.removeAttribute("count");
		
//		String value = this.getServletContext().getInitParameter("teachername");
//		//InputStream is = this.getServletContext().getResourceAsStream("db.properties");
//		InputStream is = ContextServlet.class.getClassLoader().getResourceAsStream("db.properties");
//		Properties pros = new Properties();
//		pros.load(is);
//		resp.getWriter().println(value+"<br/>");
//		resp.getWriter().print("driver:"+pros.getProperty("driver")+"<br/>");
//		resp.getWriter().print("url:"+pros.getProperty("url"));
		//网站计数器
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ServletContext sc = this.getServletContext();
		if(sc.getAttribute("count")==null){//第一个访问者
			sc.setAttribute("count", 1);
			
		}else{
			int count = (Integer)sc.getAttribute("count");
			sc.setAttribute("count", ++count);
		}
		resp.getWriter().print("您是第"+sc.getAttribute("count")+"位访问者");
		
	
	}
}
