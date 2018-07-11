<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX 测试</title>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
	var xhr;
	
	function init() {
		xhr = getXMLHttpRequest();
		if(xhr) {
			xhr.onreadystatechange = handleResponse;
		} else {
			alert("你的浏览器不支持ajax！推荐使用firefox或者chrome浏览器访问！");
		}
	}
	
	function loadRandomNumber() {
		if(xhr) {
			xhr.open("GET", "getNumber.action");
			xhr.send(null);
		}
	}
	
	function handleResponse() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200 || xhr.status == 304) {
				alert(xhr.responseText);
			}
		}
	}
</script>
</head>
<body onload="init()">
	<input type="button" value="获取随机数" onclick="loadRandomNumber()">
</body>
</html>