package com.zzy.album.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzy.album.biz.AlbumBiz;
import com.zzy.album.biz.impl.AlbumBizImpl;
import com.zzy.album.entity.Album;

public class ListAlbumServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlbumBiz albumBiz = new AlbumBizImpl();
		
		List<Album> allAlbum = albumBiz.getAllAlbum();
		req.setAttribute("albumList", allAlbum);
		req.getRequestDispatcher("showAlbumList.jsp").forward(req, resp);
	}
}
