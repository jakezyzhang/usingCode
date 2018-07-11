package com.zzy.city.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzy.city.biz.CityBiz;
import com.zzy.city.biz.impl.CityBizImpl;
import com.zzy.city.dao.CityDao;
import com.zzy.city.dao.mysql.CityDaoImpl;
import com.zzy.city.entity.City;

public class CityListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		boolean result = false;
		HttpSession session = req.getSession();
		String strName = req.getParameter("provName");
	
		session.setAttribute("provName", strName);
		if(strName != null){
			try {
//				int provId = Integer.parseInt(strId);
//				
//				List<City> city = new CityDaoImpl().getCityNameByProvId(provId);
				List<City> city = new CityDaoImpl().getCityNameByProvName(strName);
				req.setAttribute("city", city);
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
