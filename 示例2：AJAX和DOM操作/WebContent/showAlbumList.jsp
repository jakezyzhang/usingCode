<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<%@ page import="java.util.*,com.zzy.album.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>显示所有专辑</title>
		<link rel="stylesheet" href="css/tooltip_test.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript">
			var popup;
			var xhr;
			var currentNode;
			$(function () {
				xhr = getXMLHttpRequest();
				if(xhr) {
					xhr.onreadystatechange = handleAlbumDetail;
				} else {
					alert("你的浏览器不支持AJAX！");
				}

				popup = $("#popup");
				popup.remove();
				
				$(".showPopup").bind({
					mouseover: function() {
						if(xhr) {
							currentNode = $(this);
							var albumId = $(this).attr("albumId");
							xhr.open("Get", "getAlbumDetail.action?id=" + albumId);
							xhr.send(null);
						}
					},
					mouseout: function() {
						xhr.abort();
						popup.remove();
					}
				});
			});
			
			function handleAlbumDetail() {
				if(xhr.readyState == 4) {
					if(xhr.status == 200 || xhr.status == 304) {
						var result = xhr.responseText;
						popup.html(result);
						currentNode.parents("span").parents("li").append(popup);
					}
				}
			}
		</script>
	</head>
	<body>
		<div id="tempatemo_content_wrapper">
			<div id="templatemo_content">
				<jsp:useBean id="albumList" class="java.util.ArrayList" scope="request" />
				<c:choose>
					<c:when test="${ empty albumList }">
						<div>没有任何专辑！</div>
					</c:when>
					<c:otherwise>
						<ul class="footer_flex clearfix">
							<c:forEach items="${ albumList }" var="album" varStatus="status">
								<li id="item${ status.index }">
									<img src="cover/${ album.cover }" class='img-n'>
									<span class="itemTitle">
										<a href="" ></a>
										<a class="showPopup" href="getAlbumDetail.action?id=${album.id }" albumId="${ album.id }">${ album.name }</a>
									</span>
									<c:if test="${ status.index == 7}">
										<div class="flex-footer" id="popup">
										</div>
									</c:if>
								</li>
							</c:forEach>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</body>
</html>