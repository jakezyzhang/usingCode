package com.zzy.city.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.zzy.city.biz.ProvBiz;
import com.zzy.city.biz.impl.ProvBizImpl;
import com.zzy.city.dao.mysql.DistDaoImpl;
import com.zzy.city.entity.District;
import com.zzy.city.entity.Province;

public class GetCityDetailServlet extends HttpServlet{
	
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
		HttpSession session = req.getSession();
		
		//省份名
		String provName = (String)session.getAttribute("provName");
		session.setAttribute("provName", provName);
		
		//城市名
		String cityName = (String)session.getAttribute("cityName");
		session.setAttribute("cityName", cityName);

		//区域名
			
		String distName = (String)session.getAttribute("distName");
		session.setAttribute("distName", distName);
		
		resp.sendRedirect("result.jsp");
}
}
