<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/common.css?after" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>글 작성 페이</title>
</head>
<body>
	<form>
		<table>
		  	<tr>
		  	<td id="noun">会社</td>
		  		<td>
		  		<input type="radio" name="IntelAndAMD" value="intel"/>Intel
		  		<input type="radio" name="IntelAndAMD" value="amd" checked />Amd
				</td>		  	
		  	</tr>
		  	<tr>
		  		<td id="noun">CPU名</td>
		  		<td><input type="text" name=cpuName/></td>
		  	</tr>
		  	<tr>
		  		<td id="noun">socket</td>
		  		<td><input type="text" name=socket/></td>
		  	</tr>
		  	<tr>
		  		<td id="noun">speed</td>
		  		<td><input type="text" name=speed/></td>
		  	</tr>
			 <tr>
		  		<td id="noun">Core</td>
		  		<td> 　
		  		   <SELECT id="listBox" name='core'> 
			        <OPTION value='dual'>Dual-Core CORE : 2 </OPTION>
			        <OPTION value='triple'>Triple-Core CORE : 3 </OPTION>
			        <OPTION value='quad'>Quad-Core CORE : 4 </OPTION>
			        <OPTION value='hexa'>Hexa-Core CORE : 6 </OPTION>
			        <OPTION value='octa'>Octa-Core CORE : 8 </OPTION>
			        <OPTION value='deca'>Deca-Core CORE : 10 </OPTION>
			        <OPTION value='dodesa'>Dodesa-Core CORE : 12 </OPTION>
			      </SELECT>
				</td>
		  	</tr>
			<tr>
		  		<td id="noun">Thread</td>
		  		<td>
		  		   <SELECT id="listBox" name='thread'> 
			        <OPTION value='2'>thread : 2 </OPTION>
			        <OPTION value='4'>thread : 4 </OPTION>
			        <OPTION value='8'>thread : 8 </OPTION>
			        <OPTION value='16'>thread : 16 </OPTION>
			      </SELECT>
				</td>
		  	</tr>
		  		<tr>
		  		<td id="noun">graphic</td>
		  		<td>
		  		<input type="radio" name="graphic" value="yes" checked/>内臓
		  		<input type="radio" name="graphic" value="no" />なし
		  		</td>
		  	</tr>
  		</table>
	</form>
 
</body>
</html>