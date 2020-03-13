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

<link href="resources/css/magamodify.css" rel="stylesheet">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>DanceMoa MagazineRegist</title>
</head>
<body>
<c:import url="/include/header"></c:import>
<form action="magamodify" id="magamodiForm" method="post" enctype="multipart/form-data">
  <div class="container">
  <h1 id = "a">잡지 수정</h1>
  <div class="middle">
  <input type="hidden" name="mno" value="${magamodify.mno}">
	  <table>
	  	<tr class="linetop">
	  		<td>제목</td><td><input type="text" id="title" name="mtitle" value="${magamodify.mtitle}"></td>
	  	</tr>
	  	<tr class="line">
	  	<td>부제</td><td><input type="text" id="subtitle" name="msubtitle" value="${magamodify.msubtitle}"></td>
	  	</tr>
	  	<tr class="line">
	  		<td>포스터</td>
	  		<td>
	  				<input type="file" id="file">
	  				<div id="uploadedList"></div>
	  			<c:forEach items="${getAttachList}" var="gal">
			  		<div class="imgdelete" >
			  		<img id="dbimg" src="displayFile?fileName=${gal}"/>
			  		 <a href="#"  id="imgdelete" data-src='${gal}'>X</a>
			  		</div>
			  		<br>
			  	</c:forEach>
	  		</td>
	  	</tr>
	  	<tr class="line">
	  		<td>내용</td><td><textarea rows="50" cols="120" name="mcontent">${magamodify.mcontent}</textarea></td>
	  	</tr>
	  	<tr class="linebottom">
	  		<td colspan="2" align="center"><input type="submit" id="modisubmit" onclick="magamodifing()" value="수정"></td>
	  	</tr>
	  </table>
  </div>	
  </div>
</form>
<script src="resources/js/magamodify.js"></script>
<c:import url="/include/footer"></c:import>
</body>
</html>