package com.zzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.dao.BookDao;
import com.zzy.entity.Book;

public class SelectByIdServlet extends HttpServlet{
	private BookDao bookDao = new BookDao(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取id
		int id = 0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		//根据id查询对应记录
		}
		Book book = bookDao.getById(id);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>书籍列表</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.println("<form action='update' method='post'>");
		pw.print("<table width='80%' align='center'>");
		pw.print("<tr><td colspan='2' align='center'>修改书籍</td></tr>");
		pw.print("<tr>");
		pw.print("<td>");
		pw.print("书名：<input type='hidden' name='id' value='"+book.getId()+"'/>");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("<input type='text' name='name' value = '"+book.getName()+"' />");
		pw.print ("</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>");
		pw.print("价格：");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("<input type='text' name='price' value = '"+book.getPrice()+"' />");
		pw.print ("</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>");
		pw.print("作者：");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("<input type='text' name='author' value = '"+book.getAuthor()+"' />");
		pw.print ("</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td colspan='2' align='center'>");
		pw.print("<input type='submit'  value ='修改'  />");
		pw.print ("</td>");
		pw.print("</tr>");
		
		pw.print("</table>");
		pw.println("</form>");
		pw.print("</body>");
		pw.print("</html");
		
		
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
