package com.zzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPageServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		
		Cookie cks[] = req.getCookies();
		Cookie nameCk=null;
		//Cookie passwordCk=null;
		if(cks!=null)
		for(Cookie ck:cks){
			
			if("username".equals(ck.getName())){
				nameCk = ck;
			}

		}
		PrintWriter pw = resp.getWriter();
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>Insert title here</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<form action='logins' method='post'>");
		pw.print("<table>");
		pw.print("<tr>");
		pw.print("<td>用户名</td>");
		pw.print("<td><input type='text' name='name' value='"+(nameCk!=null?nameCk.getValue():"")+"'/></td>");
		pw.print("</tr>");
		pw.print("<tr>");
		pw.print("<td>密码</td>");
		pw.print("<td><input type='password' name='pwd' /></td>");
		pw.print("</tr>");
		pw.print("<tr>");
		pw.print("<td><input type='checkbox' name='remember' value='1' />记住密码</td>");
		pw.print("<td><input type='submit' value='提交' /></td>");
		pw.print("</tr>");
		pw.print("</table>");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
		
	}
}
