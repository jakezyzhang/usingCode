package com.zzy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.google.gson.Gson;
import com.zzy.entity.*;

@WebServlet("/list")
public class ListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1,"java","sun",55.5));
		list.add(new Book(2,"c#","Microsoft",45.5));
		list.add(new Book(3,"c++","Microsoft",35.5));
		list.add(new Book(4,".net","Microsoft",65.5));
//		String html = "[";
		resp.setCharacterEncoding("utf-8");
//		for(int i=0;i<list.size();i++){
//			if(i>0)html+=",";
//			html+="{id:'"+list.get(i).getId()
//					+"',name:'"+list.get(i).getName()
//					+"',author:'"+list.get(i).getAuthor()
//					+"',price:'"+list.get(i).getPrice()+"'}";
//		}
//		html+="]";
//		resp.getWriter().print(html);
		resp.getWriter().print(new Gson().toJson(list));
	
	}
}
