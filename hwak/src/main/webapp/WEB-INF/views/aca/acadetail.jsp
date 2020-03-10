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
<script src="resources/js/acadetail.js"></script>
<link href="resources/css/acadetail.css" rel="stylesheet">
<title>DanceMoa Academy</title>
</head>
<body>
<c:import url="/include/header"></c:import>
<form id="acaForm" method="get">

<div class="middle">
<!-- Page Content -->
  <div class="container">
	<h1 id="a">Academy</h1>
  	<div class="row">
   <div class="col-md-8">
   	<div class="input-group">
    	<input type="hidden" name="pageNum" value="${page.cri.getPageNum()}">
    	<input type="hidden" name="amount" value="${page.cri.getAmount()}">
    	<input type="hidden" name="ano" value="${detail.ano}">
    	<input type="text" name="keyword" class="search" aria-label="Search" aria-describedby="basic-addon2">
    	<div class="input-group-append">
    		<input type="submit" value="검색" class="btn-primary">
    	</div>
    </div>
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
<h1>${detail.aname}</h1>
<table>

		<tr class="linetop">
	  		<td>${detail.ano}</td>
	  	</tr>
	  	<tr class="line">
	  		
	  		<td>전문분야 : ${detail.atype} | 작성일 : ${detail.aregdate} | Views : ${detail.acnt} | ${detail.arcm} | 지역 : ${detail.aarea} | 대표 : ${detail.amaster}</td>
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
	  		
	  		<td><textarea rows="10" cols="70">${detail.acontent}</textarea></td>
	  	</tr>
	  	<tr class="linebottom">
	  		
	  		<td>${detail.awriter}</td>
	  	</tr>
	  	
</table>
</div>
  </div>
  
</form>
<c:import url="/include/footer"></c:import>
</body>
</html>