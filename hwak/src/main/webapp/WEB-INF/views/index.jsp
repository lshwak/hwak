<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
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
<script type="text/javascript" src="resources/js/index.js"></script>
<link href="resources/css/index.css" rel="stylesheet">
 <title>DanceMoa Korea</title>
</head>
<body>
<c:import url="/include/header"></c:import>
  <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      
      
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url('displayFile?fileName=${eventSelect.fn}')" onclick="slideimg('detail?eno=${eventSelect.eno}')">
        
          <div class="carousel-caption d-none d-md-block">
            <h3>${eventSelect.esubject}</h3>
            <p>일시: ${eventSelect.edate} | 타입: ${eventSelect.etype} | Views: ${eventSelect.ecnt}</p>
          </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('displayFile?fileName=${magaSelect.fn}')" onclick="slideimg('magadetail?mno=${magaSelect.mno}')">
          <div class="carousel-caption d-none d-md-block">
            <h3>${magaSelect.mtitle}</h3>
            <p>This is a description for the second slide.</p>
          </div>
        </div>
        
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('displayFile?fileName=${acaSelect.fn}')"onclick="slideimg('acadetail?ano=${acaSelect.ano}')">
          <div class="carousel-caption d-none d-md-block">
            <h3>${acaSelect.aname}</h3>
            <p>전문분야 : ${acaSelect.atype} | 작성일 : ${acaSelect.aregdate} | Views : ${acaSelect.acnt} | ${acaSelect.arcm} | 지역 : ${acaSelect.aarea} | 대표 : ${acaSelect.amaster}</p>
          </div>
        </div>
        
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </header>

  <!-- Page Content -->
  <div class="container">

    <h1 class="my-4">Welcome to Dance Moa</h1>
    
    <div class="row">
    
    <!-- 최근 event -->
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="detail?eno=${eventSelect.eno}"><img height="250" class="card-img-top" src="displayFile?fileName=${eventSelect.fn}" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="detail?eno=${eventSelect.eno}">${eventSelect.esubject}</a>
            </h4>
            <p class="card-text">일시: ${eventSelect.edate} <br> 타입: ${eventSelect.etype} <br>Views: ${eventSelect.ecnt}</p>
          </div>
        </div>
      </div>
      
      <!-- 최근 magazine -->
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="magadetail?mno=${magaSelect.mno}"><img height="250" class="card-img-top" src="displayFile?fileName=${magaSelect.fn}" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="magadetail?mno=${magaSelect.mno}">${magaSelect.mtitle}</a>
            </h4>
            <p class="card-text"></p>
          </div>
        </div>
      </div>
      
      <!-- 최근 academy -->
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="acadetail?ano=${acaSelect.ano}"><img height="250" class="card-img-top" src="displayFile?fileName=${acaSelect.fn}" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="acadetail?ano=${acaSelect.ano}">${acaSelect.aname}</a>
            </h4>
            <p class="card-text">전문분야 : ${acaSelect.atype} | 작성일 : ${acaSelect.aregdate} | Views : ${acaSelect.acnt} | ${acaSelect.arcm} | 지역 : ${acaSelect.aarea} | 대표 : ${acaSelect.amaster}</p>
          </div>
        </div>
      </div>
      
      
      
    </div>
    </div>
<!-- /.row -->
<c:import url="/include/footer"></c:import>
</body>
</html>