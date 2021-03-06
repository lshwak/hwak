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
<script src="resources/js/magadetail.js"></script>
<link href="resources/css/magadetail.css" rel="stylesheet">
<title>DanceMoa Magazine</title>
</head>
<body>
<c:import url="/include/header"></c:import>
<form id="magaForm" method="get">

<div class="middle">
<!-- Page Content -->
  <div class="container">
	<h1 id="a">Magazine</h1>
  	<div class="row">
   <div class="col-md-8">
   <input type="hidden" name="mno" value="${detail.mno}">
    </div>
    
    <div class="modclass">	
    	<div class="modify-area">
    		<input type="submit" value="수정" id="modi">
    	</div>
    </div>
    <div class="delclass">	
    	<div class="modify-area">
    		<input type="submit" value="삭제" id="del">
    	</div>
    </div>
   </div>
<h1>${detail.mtitle}</h1>
<table>

		<tr class="linetop">
	  		<td>${detail.msubtitle}</td>
	  	</tr>
	  	<tr class="line">
	  		
	  		<td>${detail.mtype} | ${detail.mregdate} | Views : ${detail.mcnt} | ${detail.mrcm}</td>
	  	</tr>
	  	
	  	<tr class="line">
	  		
	  		<td>
	  		<c:forEach items="${getAttachList}" var="gal">
	  		<img src="displayFile?fileName=${gal}"/>
	  		<br>
	  		</c:forEach>
	  		</td>
	  	</tr>
	  	<tr class="line">
	  		
	  		<td><textarea rows="50" cols="120">${detail.mcontent}</textarea></td>
	  	</tr>
	  	<tr class="linebottom">
	  		
	  		<td>${detail.mwriter}</td>
	  	</tr>
	  	
</table>
</div>
  </div>

</form>
<c:import url="/include/footer"></c:import>
</body>
</html>