package com.zzy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.dao.BookDao;
import com.zzy.entity.Book;

public class ListServlet extends HttpServlet{
	private BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Book> list = bookDao.getAll();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>书籍列表</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<table width='80%' align='center'>");
		pw.println("<tr><td><a href='add.html'>添加书籍</a></td></tr>");
		pw.print("<tr>");
		pw.print("<td>");
		pw.print("编号");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("书名");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("价格");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("作者");
		pw.print ("</td>");
		pw.print("<td>");
		pw.print("操作");
		pw.print ("</td>");
	
		pw.print("</tr>");
		if(list!=null)
		for(int i=0;i<list.size();i++){
			pw.print("<tr>");
			pw.print("<td>");
			pw.print(list.get(i).getId());
			pw.print ("</td>");
			pw.print("<td>");
			pw.print(list.get(i).getName());
			pw.print ("</td>");
			pw.print("<td>");
			pw.print(list.get(i).getPrice());
			pw.print ("</td>");
			pw.print("<td>");
			pw.print(list.get(i).getAuthor());
			pw.print ("</td>");
			pw.print("<td>");
			pw.print("<a href='selectById?id="+list.get(i).getId()+"'>修改</a><a href='delete?id="+list.get(i).getId()+"'>删除</a>");
			pw.print ("</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
