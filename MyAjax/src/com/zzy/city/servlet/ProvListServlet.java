package com.zzy.city.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.city.biz.CityBiz;
import com.zzy.city.biz.DistBiz;
import com.zzy.city.biz.ProvBiz;
import com.zzy.city.biz.impl.CityBizImpl;
import com.zzy.city.biz.impl.DistBizImpl;
import com.zzy.city.biz.impl.ProvBizImpl;
import com.zzy.city.dao.CityDao;
import com.zzy.city.dao.mysql.CityDaoImpl;
import com.zzy.city.entity.City;
import com.zzy.city.entity.District;
import com.zzy.city.entity.Province;


public class ProvListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProvBiz provBiz = new ProvBizImpl();
		List<Province> allProvince = provBiz.getAllProv();
		req.setAttribute("provList", allProvince);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}

