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
		String message = "123";
		if(list.size()==0){
			req.setAttribute("message", message);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
