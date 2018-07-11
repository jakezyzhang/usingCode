<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="注册">

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function refreshCaptcha(obj) {
		  obj.src = "captcha.jsp?" + Math.random();  
	}
	
	$(function() {
		
		refreshCaptcha();
		
		$("#captchaImg").click(function (){
			refreshCaptcha();
		});
	});
	
	function checkForm() {
		if($("#captcha").val() == null || $("#captcha").val() == "") {
			$("#message").text("请填写验证码");
			return false;
		} 
	}
</script>
</head>

<body>
	<form class="registerForm" name="register" method="post"
		action="doRegister.jsp" onsubmit="return checkForm();">
		
				*验证码：
				<input type="text" name="captcha" id="captcha">
				
					<img id="captchaImg" src="captcha.jsp" onclick="javascript:refreshCaptcha(this)"/>
				
				<span style="color: red;" id="message">
					<%= request.getAttribute("message")==null?"":request.getAttribute("message") %>
				</span><br/>
				<input type="submit" value="注册">
			</tr>
		</table>
	</form>
</body>
</html>
