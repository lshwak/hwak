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
<script src="resources/js/academy.js"></script>
<link href="resources/css/academy.css" rel="stylesheet">
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
    	
    	<input type="text" name="keyword" class="search" aria-label="Search" aria-describedby="basic-addon2">
    	<div class="input-group-append">
    		<input type="submit" value="검색" id="asearch" class="btn-primary">
    	</div>
    </div>
    </div>
    <div class="col-md-4">	
    	<div class="regist-area">
    		<input type="submit" value="등록" id="aregist" class="btn-regist">
    	</div>
    </div>
   </div>

<table>
<c:forEach items="${academy}" var="academys">
	<tr class="line">
		<td>
			<c:choose>
			<c:when test="${academys.fn ne null && academys.fn ne '' }">
				<a href="acadetail?ano=${academys.ano}"><img class="card-img-top" src="displayFile?fileName=${academys.fn}"></a>
			</c:when>
			<c:otherwise>
				<a href="acadetail?ano=${academys.ano}"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
			</c:otherwise>
			</c:choose>
		</td>
		<td class="textcontent">
			<h4><a href="acadetail?ano=${academys.ano}">${academys.aname}</a></h4><br>
			${academys.atype} | ${academys.aarea} 
		</td>
	</tr>
	</c:forEach>

</table>

	<div class="pagingbox">
  		<table>
	  		<tr>
	  			<td>
	  				<c:if test="${page.prev}">
	  					<a href="academy?pageNum=${page.startPage - 1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">이전</a>
	  				</c:if>
	  				
	  				<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
	  					<a href="academy?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
	  				</c:forEach>
	  				
	  				<c:if test="${page.next}">
	  					<a href="academy?pageNum=${page.endPage + 1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">다음</a>
	  				</c:if>
	  			</td>
	  		</tr>
  		</table>
  	</div>
</div>
  </div>

</form>
<c:import url="/include/footer"></c:import>
</body>
</html>