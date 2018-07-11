package com.zzy.album.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;
import com.zzy.album.biz.AlbumBiz;
import com.zzy.album.biz.impl.AlbumBizImpl;
import com.zzy.album.entity.Album;

public class GetAlbumDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = false;
		String strId = req.getParameter("id");
		if (strId != null) {
			try {
				int id = Integer.parseInt(strId);
				AlbumBiz albumBiz = new AlbumBizImpl();
				Album album = albumBiz.getAlbumById(id);
				req.setAttribute("album", album);
				result = true;
				req.getRequestDispatcher("showAlbumDetail.jsp").forward(req, resp);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(!result) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<div>Cannot get the detail of the album!</div>");
			out.close();
		}
	}
}
