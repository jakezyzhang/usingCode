<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="album" class="com.zzy.album.entity.Album" scope="request"></jsp:useBean>
<div>
	<div>艺术家：<span>${ album.artist }</span></div>
	<div>发行日期：<span>${ album.releaseDate }</span></div>
	<div>简介：<span>${ album.description }</span></div>
</div>