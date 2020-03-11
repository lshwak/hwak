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
<script src="resources/js/memberaction.js"></script>
<link href="resources/css/login.css" rel="stylesheet">
<title>DanceMoa Login</title>
</head>
<body>

<c:import url="/include/header"></c:import>
<div class="container">
  <h1 id="a">Login</h1>
  
	  	<div class="middle">
	  		<div id="log_box">
			<form id="form1">
				<input type="text" name="logid" placeholder="ID" pattern="^([a-z0-9_]){3,12}$"><br>
				<input type="password" name="logpassword" placeholder="PW" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_-+=[]{}~?:;`|/]).{8,12}$"><br>
			</form>
			<input type="submit" value="로그인" onclick="btn_click('login')">
			<input type="submit" value="회원가입" onclick="btn_click('member')">
			<!-- submit을 form 밖으로 꺼내줘서 자바스크립트로 전송. form안에 submit은 하나여야해. -->
		
			</div>
		</div>
</div>

</body>
<c:import url="/include/footer"></c:import>

