package com.zzy.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getRealPath("/download");

		File file = new File(path,"t.txt");
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename='t.txt'");
	
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
