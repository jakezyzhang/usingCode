package com.zzy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.dao.BookDao;

public class DeleteServlet extends HttpServlet {
	private BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("text/html;charset=utf-8");
		int id = 0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		}
		if(bookDao.delete(id)>0){
			resp.sendRedirect("list");
		}else{
			resp.getWriter().print("delect lose");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
