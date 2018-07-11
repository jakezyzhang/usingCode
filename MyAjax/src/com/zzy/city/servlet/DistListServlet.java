package com.zzy.city.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzy.city.dao.mysql.DistDaoImpl;
import com.zzy.city.entity.District;

public class DistListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		boolean result = false;
		HttpSession session = req.getSession();
		String strName = req.getParameter("cityName");
		
		session.setAttribute("cityName", strName);
		if(strName != null){
			try {
				List<District> district = new DistDaoImpl().getDistNameByCityName(strName);
				req.setAttribute("dist", district);
				result = true;
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!result){
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<div>Cannot get the detail of the city!</div>");
			out.close();
			}
		}
}
