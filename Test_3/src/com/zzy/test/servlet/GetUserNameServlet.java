package com.zzy.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzy.test.biz.UserBiz;
import com.zzy.test.biz.impl.UserBizImpl;
import com.zzy.test.dao.mysql.UserDaoImpl;
import com.zzy.test.entity.User;

public class GetUserNameServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
//		HttpSession session = req.getSession();
//		String username = (String)session.getAttribute("username");
//		List<User> userList = new UserDaoImpl().getUserNameByName(username);
//		req.setAttribute("userList", userList);
//		req.getRequestDispatcher("sendMessage.jsp").forward(req, resp);
		UserBiz userBiz = new UserBizImpl();
		
		List<User> allUser = userBiz.getAllUser();
		req.setAttribute("userList", allUser);
		req.getRequestDispatcher("sendMessage.jsp").forward(req, resp);
	}
}
