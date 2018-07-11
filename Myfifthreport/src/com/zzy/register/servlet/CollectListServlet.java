package com.zzy.register.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzy.register.dao.impl.CollectDaoImpl;
import com.zzy.register.entity.Collect;

public class CollectListServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		String message = "123";
		
		List<Collect> list = new CollectDaoImpl().getAll(username);
		//if(list==null){
		//	req.setAttribute("list",message);
			//req.getRequestDispatcher("collect.jsp").forward(req, resp);
		//}
		req.setAttribute("list", list);
		req.setAttribute("ddd", message);
		req.getRequestDispatcher("collect.jsp").forward(req, resp);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);;
	}
}
