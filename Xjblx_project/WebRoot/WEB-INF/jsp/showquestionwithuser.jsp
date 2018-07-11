<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/aboutme.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/My.css"/>
		<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/aboutme.js" type="text/javascript" charset="utf-8"></script>
		<%-- <script src="${pageContext.request.contextPath }/js/My.js" type="text/javascript" charset="utf-8"></script> --%>
		
		
		<title>我的问卷</title>
	<script type="text/javascript">
	$(document).ready( function(){
		var  arr =  eval('${questionnaireByUserList}');//用户的问卷数量
		var result=arr.length
		var index;
		for(index = 0;index < result;index++) {

			var newNode = $("#text").clone(true);
			newNode.removeAttr("id");
			if(index == 0){
				newNode.appendTo("#show");
				
				$("#showTitle .surveyHead span").text(index+1 + "." +arr[index].questionnairName);//index == 1
				$("#showTitle .survey:last .surveyDescribe").text(arr[index].createdate)
				//onclick="window.location.href="${pageContext.request.contextPath }\/countEachNum.action?questionnairName='+arr[index].questionnairName+'"
						//onclick="window.location.href="${pageContext.request.contextPath }/showQuestionDetails.action?questionnairName='+arr[index].questionnairName+'"
								// onclick="window.location.href="${pageContext.request.contextPath }\/delectQuestionnaire.action?id='+arr[index].id+'"
				$("#showTitle .survey:last .surveyDescribe").append('<input type="button" class="create1" id="create" value="发布问卷" />')
				$("#showTitle .survey:last .surveyDescribe").append('<input type="button" class="create2" id="create" value="统计问卷"  />')
				$("#showTitle .survey:last .surveyDescribe").append('<input type="button" class="create3" id="create" value="删除问卷" />')
				$('.text a:eq(0)').attr("href",'${pageContext.request.contextPath }/showQuestionnaire.action'); 
				$("#showTitle .survey").css("display","block");
				
				$(".create1:last").attr("onclick",'window.location.href="${pageContext.request.contextPath }/countEachNum.action?questionnairName='+arr[index].questionnairName+'"');
				$(".create2:last").attr("onclick",'window.location.href="${pageContext.request.contextPath }/showQuestionDetails.action?questionnairName='+arr[index].questionnairName+'"');
				
				$(".cteate3:last").attr("onclick",'window.location.href="${pageContext.request.contextPath }/delectQuestionnaire.action?id='+arr[index].id+'"');
				//window.location.href="${pageContext.request.contextPath }/delectQuestionnaire.action?id='+arr[index].id+'"

				/*
				$(".create1:last").click(function(){
					window.location.href="'"+${pageContext.request.contextPath }+"/countEachNum.action?questionnairName="+arr[index].questionnairName+"'";
				})*/
				
			}else{
				newNode.insertAfter("#showTitle .text:last");
				$("#showTitle .survey:last .surveyHead").text(index+1 + "."+ arr[index].questionnairName);
				$("#showTitle .survey:last .surveyDescribe").text(arr[index].createdate)
				
								$("#showTitle .survey:last .surveyDescribe").append('<input type="button" class="create1" id="create" value="发布问卷"  />')
				$("#showTitle .survey:last .surveyDescribe").append('<input type="button" class="create2" id="create" value="统计问卷"  />')
				$("#showTitle .survey:last .surveyDescribe").append('<input type="button" class="create3" id="create" value="删除问卷"  />')
				
				$("#showTitle .survey").css("display","block");
				
				$(".create1:last").attr("onclick",'window.location.href="${pageContext.request.contextPath }/countEachNum.action?questionnairName='+arr[index].questionnairName+'"');
				$(".create2:last").attr("onclick",'window.location.href="${pageContext.request.contextPath }/showQuestionDetails.action?questionnairName='+arr[index].questionnairName+'"');
				
				$(".cteate3:last").attr("onclick",'window.location.href="${pageContext.request.contextPath }/delectQuestionnaire.action?id='+arr[index].id+'"');
			}
			
		}
		
		$("#showTitle .survey a").click(function(){ //获取选中的a标签中的文字this.innerText
			alert(this.innerText);
		})
		
	})
	
	</script>
	</head>
	
	<body id="main">
	<div id="banner">
			<img src="img/logo2.png"/>
			<ul class="choose">
				<li><a href="${pageContext.request.contextPath }/showQuestionnairewithuser.action">我的问卷</a></li>
				<li>
					<a href="#" id="myaccout">${sessionScope.username }</a>
					<ul id="about">
						<li><a href="${pageContext.request.contextPath }/showPersonCenter.action">个人中心</a></li>
						<li><a href="${pageContext.request.contextPath }/changePassword2.action">修改密码</a></li>
					</ul>
				</li>
			</ul>
		</div>
	<div id="showTitle">
		<div id="show">
			<pre>
				<a id="createQuestion" href="${pageContext.request.contextPath }/questionnaire.action" >添加问卷</a>
				
			</pre>
		</div>
		
	</div>
	
	<div id="text" class="text">
	
          
		<div id="survey" class="survey" >
			<a class="surveyHead">
			
			<span>
						
			</span>
			</a>
			<div class="surveyDescribe">
				
			
			</div>
		
	</div>
		
	</body>
</html>