<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
 <body>
<div>  
<%  
    String inputCode = request.getParameter("inputCode");  
    String verifyCode = (String)session.getAttribute("validateCode");  
    if(inputCode!=null && verifyCode!=null){  
        out.print("真正的验证码：" + verifyCode + "<br/>" + "用户输入的验证码：" + inputCode + "<br/>");  
        inputCode = inputCode.toUpperCase();//不区分大小写  
        out.print("比较验证码证明用户输入 " + (inputCode.equals(verifyCode)?"正确":"错误") + "！");  
    }  
%>  
<form action="index.jsp">  
验证码：<input name="inputCode" value=""/>   
<img src="VerifyCodeServlet" align="middle" title="看不清，请点我"  onclick="javascript:refresh(this);" onmouseover="mouseover(this)"/><br/>  
<input name="submit" type="submit" value="提交"/>  
</form>  
</div>  
<script>  
    function refresh(obj){  
         obj.src = "VerifyCodeServlet?" + Math.random();  
    }  
      
    function mouseover(obj){  
        obj.style.cursor = "pointer";  
    }  
</script>  
</body>  
</html>  