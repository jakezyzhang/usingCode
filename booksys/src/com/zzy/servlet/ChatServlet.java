package com.zzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = (String) req.getSession().getAttribute("username");
		if(name==null){
			resp.sendRedirect("loginHtml");
			return;
		}
		//获取messag
		String msg = req.getParameter("msg");
		ServletContext sc = this.getServletContext();
		if(sc.getAttribute("content")==null){
			sc.setAttribute("content", "");
		}
		
		
		String content = (String)sc.getAttribute("content");
		if(msg!=null){
			content += name+":"+msg+"\r\n";
		}
		
		sc.setAttribute("content", content);
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html>");
		pw.print("<head><title>网络聊天室</title></head>");
		pw.print("<head>");
		pw.print("<title>Insert title here</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<form action=\"chat\" method=\"post\">");
		pw.print("<textarea cols='60' rows='10' name='context' >"+content+"</textarea>");
		pw.print("<input type='text' name='msg' />");
		pw.print("<input type='submit' value='发送' />");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
