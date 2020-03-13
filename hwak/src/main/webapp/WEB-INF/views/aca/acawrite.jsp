<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/modern-business.css" rel="stylesheet">
<script type="text/javascript" src="resources/plugins/jQuery/jquery-3.4.1.js"></script>

<link href="resources/css/acawrite.css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>DanceMoa AcademyRegist</title>
</head>
<body>
<c:import url="/include/header"></c:import>
<form action="aregister" id="aregistForm" method="post" enctype="multipart/form-data">
  <div class="container">
  <h1 id = "a">학원 등록</h1>
  <div class="middle">
	  <table>
	  	<tr class="linetop">
	  		<td>학원 명</td><td><input type="text" id="title" name="aname"></td>
	  	</tr>
	  	<tr class="line">
	  		<td>전문 분야</td><td><input type="text" id="subtitle" name="atype"></td>
	  	</tr>
	  	<tr class="line">
	  		<td>대표자</td><td><input type="text" id="title" name="amaster"></td>
	  	</tr>
	  	<tr class="line">
	  		<td>지역</td><td><input type="text" id="title" name="aarea"></td>
	  	</tr>
	  	<tr class="line">
	  		<td>이미지</td>
	  		<td>
	  			<input type="file" id="file">
	  			<div id="uploadedList"></div>
	  		</td>
	  	</tr>
	  	<tr class="line">
	  		<td>소개내용</td><td><textarea rows="50" cols="120" name="acontent"></textarea></td>
	  	</tr>
	  	<tr class="linebottom">
	  		<td colspan="2" align="center"><input type="submit" id="acasubmit" onclick="acamaking()" value="등록"></td>
	  	</tr>
	  </table>
  </div>	
  </div>
</form>
<script src="resources/js/acawrite.js"></script>
<c:import url="/include/footer"></c:import>
</body>
</html>