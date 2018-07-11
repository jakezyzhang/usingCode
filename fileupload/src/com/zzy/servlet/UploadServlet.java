package com.zzy.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		//得到提交的数据流
		InputStream is = req.getInputStream();
		//上传文件写入的目录
		//String path = req.getServletContext().getContextPath()+"/upload";
		String path = req.getRealPath("/upload");
		System.out.println(path);
		File file = new File(path,"t.txt");
		OutputStream os = new FileOutputStream(file);
		byte[] buffer = new byte[200];
		int len=0;
		while((len=is.read(buffer))!=-1){
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		
	}
}
