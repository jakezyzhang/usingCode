package com.zzy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.dao.BookDao;
import com.zzy.dao.CategoryDao;
import com.zzy.entity.Book;
import com.zzy.entity.Category;
import com.zzy.util.PageUtil;

@WebServlet({"/book","/bk"})
public class BookServlet extends HttpServlet{
	private BookDao bookDao = new BookDao();
	private CategoryDao categoryDao = new CategoryDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * op=list进行查询全部
		 * op=add添加
		 * op=delete 删除
		 * op=update 修改
		 * op=getById查询单个
		 * op=toAdd 到添加页面
		 */
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("op");
		if(action==null||"list".equals(action)){
			list(req,resp);
			
		}else if("toAdd".equals(action)){
			toAdd(req,resp);
		}else if("add".equals(action)){
			add(req,resp);
		}else if("delete".equals(action)){
			delete(req,resp);
		}else if("getById".equals(action)){
			getById(req,resp);
		}else if("update".equals(action)){
			update(req,resp);		
		}
	
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		int id = 0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		//根据id查询对应记录
		}
		String bookName = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String bookAuthor = req.getParameter("author");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		Book book = new Book(id,bookName,price,bookAuthor,categoryId);
		if(bookDao.update(book)>0){
			resp.sendRedirect("book?op=list");
		}else{
			resp.getWriter().print("join lose");
		}
	}

	private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		//根据id查询对应记录
		}
		Book book = bookDao.getById(id);
		List<Category> clist = categoryDao.getList();
		req.setAttribute("clist", clist);
		req.setAttribute("book", book);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		int id = 0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		}
		if(bookDao.delete(id)>0){
			resp.sendRedirect("book?op=list");
		}else{
			resp.getWriter().print("delect lose");
		}
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub

		
		String bookName = req.getParameter("name");
		Double bookPrice = Double.parseDouble(req.getParameter("price"));
		String bookAuthor = req.getParameter("author");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		Book book = new Book(bookName,bookPrice,bookAuthor,categoryId);
		if(bookDao.add(book)>0){
			resp.sendRedirect("book?op=list");
		}else{
			resp.getWriter().print("join lose");
		}
	}

	private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> clist = categoryDao.getList();
		req.setAttribute("clist", clist);
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageUtil pageUtil = new PageUtil();
		//设置总共记录数
		pageUtil.setTotalCount(bookDao.count());
		//设置每页显示记录数
		pageUtil.setPageSize(3);
		//获取当前页--默认为第一页
		int currentPage = 1;
		if(req.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(req.getParameter("currentPage"));			
		}
		pageUtil.setCurrentPage(currentPage);
		//调用dao直接查询
		List<Book> list = bookDao.getAll(pageUtil);
		List<Category> clist = categoryDao.getList();
		req.setAttribute("list", list);
		req.setAttribute("clist", clist);
		req.setAttribute("page", pageUtil);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
