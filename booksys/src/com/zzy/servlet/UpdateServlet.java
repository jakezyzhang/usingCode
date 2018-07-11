package com.zzy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.dao.BookDao;
import com.zzy.entity.Book;

public class UpdateServlet extends HttpServlet{
	private BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int id = 0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		//根据id查询对应记录
		}
		String bookName = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String bookAuthor = req.getParameter("author");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		Book book = new Book(id,bookName,price,bookAuthor,categoryId);
		if(bookDao.update(book)>0){
//			resp.setContentType("text/html;charset=uft-8");
//			resp.getWriter().print("join SUCCESS <a href='list'>list</a>");
			resp.sendRedirect("list");
		}else{
			resp.getWriter().print("join lose");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
