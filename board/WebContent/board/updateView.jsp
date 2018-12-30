<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.vo.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修正</title>
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
</head>
<body>

<h3 style="text-align: center;">修正</h3>
<form  action ="update.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="idx" value="${vo.idx }">
<input type="hidden" name="page" value="${page }">
<table>
	<tr>
	<th>作成者</th>
	<th>${vo.name}</th>
		</tr>
	<tr><th>題目</th>
		<td><input type="text" name="subject" value="${vo.subject}"></td>
		</tr>
	<tr><th>内容</th>
		<td><textarea rows="15" cols="70" name="content">${vo.content}</textarea></td>
		</tr>
	<tr>
	  	<th id="noun">会社</th>
	  		<td>
	  		<input type="radio" name="enterprise" value="intel"/>Intel
	  		<input type="radio" name="enterprise" value="amd" checked />Amd
			</td>		  	
	  	</tr>
	  	<tr>
	  		<th id="noun">CPU名</th>
	  		<td><input type="text" name=cpuName value="${vo.cpuName}"/></td>
	  	</tr>
	  	<tr>
	  		<th id="noun">socket</th>
	  		<td><input type="text" name=socket value="${vo.socket}"/></td>
	  	</tr>
	  	<tr>
	  		<th id="noun">speed</th>
	  		<td><input type="text" name=speed value="${vo.speed}"/></td>
	  	</tr>
		 <tr>
	  		<th id="noun" >Core</th>
	  		<td> 　
	  		   <SELECT id="listBox" name="core" size ="1"> 
		        <OPTION value='2'>Dual-Core CORE : 2 </OPTION>
		        <OPTION value='3'>Triple-Core CORE : 3 </OPTION>
		        <OPTION value='4'>Quad-Core CORE : 4 </OPTION>
		        <OPTION value='6'>Hexa-Core CORE : 6 </OPTION>
		        <OPTION value='8'>Octa-Core CORE : 8 </OPTION>
		        <OPTION value='10'>Deca-Core CORE : 10 </OPTION>
		        <OPTION value='12'>Dodesa-Core CORE : 12 </OPTION>
		      </SELECT>
			</td>
	  	</tr>
		<tr>
	  		<th id="noun">Thread</th>
	  		<td>
	  		   <SELECT id="listBox" name="thread" size="1"> 
		        <OPTION value='2'>thread : 2</OPTION>
		        <OPTION value='4'>thread : 4</OPTION>
		        <OPTION value='8'>thread : 8</OPTION>
		        <OPTION value='10'>thread : 10</OPTION>
		        <OPTION value='12'>thread : 12</OPTION>
		        <OPTION value='16'>thread : 16</OPTION>
		        <OPTION value='18'>thread : 18</OPTION>
		        <OPTION value='24'>thread : 24</OPTION>
		        <OPTION value='32'>thread : 32</OPTION>
		      </SELECT>
			</td>
	  	</tr>
	  		<tr>
	  		<th id="noun">graphic</th>
	  		<td>
	  		<input type="radio" name="graphic" value="yes" checked/>内臓
	  		<input type="radio" name="graphic" value="no" />なし
	  		</td>
	  	</tr>
	<tr>
	<tr>	
		<td colspan="2">
			<input type="file" name="uploadFile1">
			
	</tr>
	<tr>	
		<td colspan="2">
			<input type="file" name="uploadFile2">
			
	</tr>
	<tr>
		<td style="text-align:center;">
		パスワード <input type="password" name="password">
		<td style="text-align:right;">
			<input type="submit" value="修正">
			<input type="reset" value="書き直し">
			<input type="button" value="目録" onclick="location.href='list.do'">
		</td>
	</tr>
</table>
</form>
</body>
</html>