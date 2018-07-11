package com.zzy.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet("/cupload")
public class CommonsUploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		//创建磁盘文件工 厂
		DiskFileItemFactory df = new DiskFileItemFactory();
		//做文件上传
		ServletFileUpload sfu = new ServletFileUpload(df);
		String path = req.getRealPath("/cupload");
		try {
			List<FileItem> list = sfu.parseRequest(req);
			for(FileItem fi:list){
				if(fi.isFormField()){//普通表单项
					System.out.println(fi.getFieldName()+"----"+fi.getName()+"-----"+fi.getString());
					if("name".equals(fi.getFieldName())){
						//book.setName(fi.getString());
					}
					if("price".equals(fi.getFieldName())){
						//book.setPrice(fi.getString());
					}
				}else{//文件上传项
					System.out.println(fi.getFieldName()+"----"+fi.getName()+"-----"+fi.getString());
					//book.setPhoto(fi.getName());
					
					
					
//					InputStream is = fi.getInputStream();
//					File file = new File(path,fi.getName());
//					OutputStream os = new FileOutputStream(file);
//					byte[] buffer = new byte[200];
//					int len=0;
//					while((len=is.read(buffer))!=-1){
//						os.write(buffer, 0, len);
//					}
//					os.close();
//					is.close();
					try {
						String fileName = UUID.randomUUID()+fi.getName().substring(fi.getName().lastIndexOf("."));
						fi.write(new File(path,fi.getName()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
