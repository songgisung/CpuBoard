<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新しい作成</title>
<style type="text/css">
		table,td,th{
	 border: 1px solid #ccc;
	 border-collapse: collapse;
	 padding: 6px;
	 margin: auto;
	 text-align: left;

	}
	th{
		text-align:left;
	}
</style>
<%--  <%@ include file="/WEB-INF/include/include-body.jspf" %> --%>
</head>
<body>
<h3 style="text-align: center;">CPU在庫追加</h3>
	<form id="form" action="create" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>作成者</th>
				<td><input type="text" name="name" size="27" style="width=100%"></td>
				<th>パスワード</th>
				<td><input type="password" name="password" size="27"></td>
			</tr>
			<tr>
				<th>題目</th>
				<td colspan="3"><input type="text" name="subject" size="72" style="width=100%"></td>
				</tr>
			<tr>
				<th>内容</th>
				<td colspan ="3"><textarea rows="15" cols="70" name="content"></textarea></td>
				</tr>
			<tr>
			  	<th id="noun">会社</th>
			  		<td>
			  		<input type="radio" name="enterprise" value="intel"/>Intel    
			  		<input type="radio" name="enterprise" value="amd" checked />Amd
					</td>	
					<th id="noun">CPU名</th>
			  		<td>
			  		<input type="text" name=cpuname  size="27" style="width:190px; text-align: left;"/>
			  		</td>	  	
			  </tr>
			  	<tr>
			  		<th id="noun">socket</th>
			  		<td><input type="text" name=socket  size="27" style="width:190px; text-align: left;"/></td>
			  		<th id="noun">speed</th>
			  		<td><input type="text" name=speed  size="27" style="width:190px; text-align: left;"/></td>
			  	</tr>
				 <tr>
			  		<th id="noun">Core</th>
			  		<td><SELECT id="listBox" name="core" size ="1" style="width:190px; text-align: left;"> 
				        <OPTION value='2'>Dual-Core CORE : 2 </OPTION>
				        <OPTION value='3'>Triple-Core CORE : 3 </OPTION>
				        <OPTION value='4'>Quad-Core CORE : 4 </OPTION>
				        <OPTION value='6'>Hexa-Core CORE : 6 </OPTION>
				        <OPTION value='8'>Octa-Core CORE : 8 </OPTION>
				        <OPTION value='10'>Deca-Core CORE : 10 </OPTION>
				        <OPTION value='12'>Dodesa-Core CORE : 12 </OPTION>
				      </SELECT>
					</td>
					<th id="noun">Thread</th>
			  		<td>
			  		   <SELECT id="listBox" name="thread" size="1" style="width:190px; text-align: left;"> 
				        <OPTION value='2'>thread : 2 </OPTION>
				        <OPTION value='4'>thread : 4 </OPTION>
				        <OPTION value='8'>thread : 8 </OPTION>
				        <OPTION value='16'>thread : 16 </OPTION>
				        <OPTION value='24'>thread : 24 </OPTION>
				        <OPTION value='32'>thread : 32 </OPTION>
				      </SELECT>
					</td>
			  	</tr>
			  		<tr>
			  		<th id="noun">graphic</th>
			  		<td colspan ="3">
			  		<input type="radio" name="graphic" value="yes" checked/>内臓
			  		<input type="radio" name="graphic" value="no" />なし
			  		</td>
			  	</tr>
			<tr>
				<td colspan="4">
					<input type="file" id="fileName1" name="fileName1" value="fileADD">
				</td>
			</tr>
				<tr>
				<td colspan="4">
					<input type="file" id="fileName2" name="FileName2" value="fileADD">
				</td>
			</tr>
			<tr>	
				<td colspan='4'>
					<input type="submit" value="作成">&nbsp;&nbsp;  
					<input type="reset" value="書き直し">&nbsp;&nbsp;
					<input type="button" value="目録" onclick="location.href='/myapp/board/list'">
				</td>
			</tr>
		
		</table>
	</form>

</body>
</html>
