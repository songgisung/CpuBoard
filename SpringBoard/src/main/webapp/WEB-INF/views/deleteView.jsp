<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除</title>
</head>
<style>
		table,td,th{
	 border: 1px solid #ccc;
	 border-collapse: collapse;
	 padding: 6px;
	 margin: auto;
	}
	th{
		text-align: center;
	}
</style>
<body>
<h3 style="text-align: center;">削除</h3>
<form action="delete" method="post">
<input type="hidden" name="idx" value=${vo.idx }>
<input type="hidden" name="page" value=${page }>
<table>
	<tr>
		<td width="100">idx</td>
		<td width="150">作成者</td>
		<td width="150">作成日</td>
		<td width="100">照会数</td>
	</tr>
	<tr>
		<td>${vo.idx }</td>
		<td>${vo.name }</td>
		<td>${vo.wdate }</td>
		<td>${vo.readCount }</td>
	</tr>
	<tr>
	<td>題目</td>
	<td colspan="3">${vo.subject }</td>
	<tr>
	<tr height="300">
	<td>内容</td>
	<td colspan="3" width="300">${vo.content }</td>
	<%-- <c:set var="rn" value="${rn }"/> --%>
	<%-- ${fn:replace(vo.content, rn, '<br>') } --%>
	</tr>
	<td colspan="4" style="text-align:center;">
		文パスワード :<input type="password" name="password">
		<input type="submit" value="削除">
		<input type="reset" value="書き直し">
		<input type="button" value="目録" onclick="loaction.href='myapp/board/list'">
	</td></tr>
			
</table>
</form>
</body>
</html>