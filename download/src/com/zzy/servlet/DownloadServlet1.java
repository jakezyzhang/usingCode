package com.zzy.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download1")
public class DownloadServlet1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getRealPath("/download");
		req.setCharacterEncoding("utf-8");
		String filename = req.getParameter("filename");
		
		File file = new File(path,filename);
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=\""+URLEncoder.encode(filename,"utf-8")+"\"");
	
		resp.setContentLength((int) file.length());
		
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[400];
		int len = 0;
		while((len=is.read(buffer))!=-1){
			resp.getOutputStream().write(buffer, 0, len);
			
		}
		is.close();
		resp.getOutputStream().close();
	}
}
