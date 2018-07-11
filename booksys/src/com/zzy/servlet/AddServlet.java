package com.zzy.servlet;

import java.io.IOException;
import com.zzy.dao.*;
import com.zzy.entity.*;
import com.zzy.servlet.*;
import com.zzy.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	private BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String bookName = req.getParameter("name");
		Double bookPrice = Double.parseDouble(req.getParameter("price"));
		String bookAuthor = req.getParameter("author");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		Book book = new Book(bookName,bookPrice,bookAuthor,categoryId);
		if(bookDao.add(book)>0){
//			resp.setContentType("text/html;charset=uft-8");
//			resp.getWriter().print("join SUCCESS <a href='list'>list</a>");
			//重定向
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
