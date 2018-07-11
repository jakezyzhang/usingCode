package com.zzy.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzy.test.dao.mysql.MessageDaoImpl;
import com.zzy.test.entity.Message;

public class GetMesseageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username =  req.getParameter("username");
		String messageLabel = req.getParameter("messageLabel");
		if(username ==null || username.equals("")){
			req.setAttribute("message", "用户名不能为空");
			req.getRequestDispatcher("message.jsp").forward(req, resp);
		} else if(messageLabel == null|| messageLabel.equals("")){
			req.setAttribute("message", "内容不能为空");
			req.getRequestDispatcher("message.jsp").forward(req, resp);
		} else{
			int count = new MessageDaoImpl().countMessageByName(username);
			Message
			
		}
		
		
	}
}
