package com.zzy.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.zzy.dao.CategoryDao;
import com.zzy.entity.Category;
@WebListener
public class ContextListener implements ServletContextListener{
	private CategoryDao categoryDao = new CategoryDao();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		List<Category> clist = categoryDao.getList();
		sc.getServletContext().setAttribute("clist", clist);
	}
	
}
