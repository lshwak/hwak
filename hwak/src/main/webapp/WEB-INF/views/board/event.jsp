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
<!-- <script src="resources/js/event.js"></script> -->
<link href="resources/css/event.css" rel="stylesheet">
<title>DanceMoa Event</title>
</head>
<body>
<c:import url="/include/header"></c:import>
<form action="register" method="get">

  <!-- Page Content -->
  <div class="container">

    <h1 id="a">Event</h1>

   <div class="row">
   <div class="col-md-8">
   	<div class="input-group">
    	<input type="hidden" name="pageNum" value="${page.cri.getPageNum()}">
    	<input type="hidden" name="amount" value="${page.cri.getAmount()}">
    	
    	<input type="text" name="keyword" class="search" aria-label="Search" aria-describedby="basic-addon2">
    	<div class="input-group-append">
    		<input type="submit" value="검색" class="btn-primary">
    	</div>
    </div>
    </div>
    <div class="col-md-4">	
    	<div class="regist-area">
    		<input type="submit" value="등록" class="btn-regist" onclick="btn_click('register')">
    	</div>
    </div>
   </div>

    <div class="row">
    <!-- Search Box -->
    
    
    <c:forEach items="${event}" var="boards">
    
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
        <c:choose>
        	<c:when test="${boards.fn ne null && boards.fn ne '' }">
        		<a href="detail?eno=${boards.eno}"><img class="card-img-top" src="displayFile?fileName=${boards.fn}"></a>
        	</c:when>
        	<c:otherwise>
        		<a href="detail?eno=${boards.eno}"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        	</c:otherwise>
        </c:choose>
          <div class="card-body">
            <h4 class="card-title">
              <a href="detail?eno=${boards.eno}">${boards.esubject}</a>
            </h4>
            <p class="card-text">일시: ${boards.edate} <br> 타입: ${boards.etype} <br>Views: ${boards.ecnt}</p>
          </div>
        </div>
      </div>
      
      </c:forEach>
      
      
      
      
      </div>
  	<div class="pagingbox">
  		<table>
	  		<tr>
	  			<td>
	  				<c:if test="${page.prev}">
	  					<a href="event?pageNum=${page.startPage - 1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">이전</a>
	  				</c:if>
	  				
	  				<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
	  					<a href="event?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num}</a>
	  				</c:forEach>
	  				
	  				<c:if test="${page.next}">
	  					<a href="event?pageNum=${page.endPage + 1}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">다음</a>
	  				</c:if>
	  			</td>
	  		</tr>
  		</table>
  	</div>
  </div>
  	
</form>
<c:import url="/include/footer"></c:import>
</body>
</html>