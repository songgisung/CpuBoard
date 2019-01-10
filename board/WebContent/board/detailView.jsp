<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="board.vo.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>詳細表示</title>
<style>
	table,td,th{
	 border: 1px solid #ccc;
	 border-collapse: collapse;
	 padding: 6px;
	 margin: auto;
	}
	th{
		text-align: left;
	}
</style>

</head>

<body>

<h3 style="text-align: center;">cpu掲示板</h3>
<table>
	<tr>
		<th>番号</th>
		<td>${vo.idx}</td>
		<th>作成日 ${vo.wdate}</th>
		<th>照会日 ${vo.readCount}</th>
	</tr>
	<tr>
		<th>作成者</th>
		<td>${vo.name}</td>
		<th>題目</th>
		<td>${vo.subject}</td>
	</tr>
	<tr>
<%--  	 	<c:if test="${vo.filename[0] != null}" >
		<td>
			<img src="/upload/${vo.filename[0]}" width="500" height="400">
		</td>
		<td colspan="3">${vo.content}</td>
		</c:if> --%>
		<td colspan ="2">
			<img src="/upload/${image[0]}" width="300" height="300">
		</td>
		<td colspan="2" width="300">${vo.content}</td>
	</tr>
	<tr>
		<th>会社</th>
		<td>${vo.enterprise }</td>
		<th>cpu名</th>
		<td>${vo.cpuName }</td>
	</tr>
	<tr>
		<th>socket</th>
		<td>${vo.socket }</td>
		<th>speed</th>
		<td>${vo.speed }</td>
	</tr>
	<tr>
		<th>core</th>
		<td>${vo.core }</td>
		<th>thread</th>
		<td>${vo.thread }</td>
	</tr>
	<tr>
		<th>graphis</th>
		<td colspan="3">${vo.graphis }</td>
	</tr>
	<tr>
		<td colspan="4" style="text-align:center;">
			<%-- <img src="/upload/${vo.filename[1] }" width="500" height="400"> --%>
			<img src="/upload/${image[1] }" width="500" >
		</td>
	</tr>
	<tr>
		<td colspan="4" style="text-align:right;">
			<input type="button" value="修正" onclick="location.href='select.do?idx=${vo.idx }&exec=update&page=${page }'">
			<input type="button" value="削除" onclick="location.href='select.do?idx=${vo.idx }&exec=delete&page=${page }'">
			<input type="button" value="目録" onclick="location.href='list.do?page=${page}'">
		</td>
	</tr>
</table>

</body>
</html>