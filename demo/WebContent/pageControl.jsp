<%@ page import="com.rainsia.news.dao.impl.*" %>
<%@ page import="com.rainsia.news.dao.*" %>
<%@ page import="com.rainsia.news.dao.util.*" %>
<%@ page import="com.rainsia.news.entity.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String pageIndex = request.getParameter("pageIndex");//获得当前页数
    if(pageIndex == null){
        pageIndex= "1";
    }
    int currPageNo = Integer.parseInt(pageIndex);
    
    NewsDao newsDao = new NewsDaoImpl();
	int totalCount = newsDao.getTotalCount();//获得总记录数
	Page pages = new Page();
	pages.setPageSize(5);    //设置每页条数
	pages.setTotalCount(totalCount);   //设置总记录数
	int totalpages = pages.getTotalPageCount();
	
	/*对首页与末页越界进行控制*/
    if(currPageNo < 1){
        currPageNo = 1;
    }else if(currPageNo > pages.getTotalPageCount()){
        currPageNo = totalpages;
    }
	
    pages.setCurrPageNo(currPageNo);    //设置当前页面
	List<News> newsList=newsDao.getPageNewsList(pages.getCurrPageNo(), pages.getPageSize());
	pages.setListNews(newsList);  //设置每页显示的集合
	
    request.setAttribute("pages", pages);
    request.getRequestDispatcher("listNews.jsp").forward(request, response);
%>

