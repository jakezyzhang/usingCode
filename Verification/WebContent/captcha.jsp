<%@ page contentType="image/jpeg" language="java" 
	import="java.util.*,java.io.*,javax.imageio.*,com.rainsia.news.cpatcha.*"
	pageEncoding="utf-8"%>
<%
	out.clear();
	out = pageContext.pushBody();

	//response.reset();
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);

	CaptchaGenerator captcha = new CaptchaGenerator(20, 60);
	captcha.generate();

	// 将认证码存入SESSION
	session.setAttribute("captcha", captcha.getValue());

	OutputStream oStream = response.getOutputStream();

	ImageIO.write(captcha.getImage(), "JPEG", oStream);
	//oStream.flush();
%>
