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
<script type="text/javascript" src="resources/js/member.js"></script>
<link rel="stylesheet" href="resources/css/member.css" />
<title>DanceMoa Member</title>
</head>
<body>
<c:import url="/include/header"></c:import>
<form method="post" action="member" id="signForm" onsubmit="return form_check()"><!-- form전송 전 입력데이터 유효성 검사 onsubmit -->
<div class="container">
<h1 id = "a">Sign Up</h1>
<div class="middle">
<table>
          
          <tr class="linetop">
                   <td>아이디(필수)</td><td><input type="text" id="idCheck" required onkeyup="checkId()" name="id">
                   <span id="idRes"></span></td>
          </tr>            
          <tr class="line">
                   <td>비밀번호(필수)</td><td><input type="password" id="pwCheck" name="password" required><span id="pwRes"></span></td>
          </tr>
          <tr class="line">
                   <td>비밀번호확인(필수)</td><td><input type="password" id="repwCheck" onkeyup="checkRepw()"><span id="repwRes"></span></td>
          </tr>
          <tr class="line">
                   <td>이름(필수)</td><td width="620"><input type="text" name="name" id="nameCheck"  required><span id="nameRes"></span></td>
          </tr>
          <tr class="line">
          		   <td>연락처</td>
                   <td>
                             <select id="pnum1" onchange="phonemerge()">
                             		  <option value="">선택</option>
                                      <option value="010">010</option>
                                      <option value="011">011</option>
                                      <option value="016">016</option>
                             </select>-
                             <input type="text" numberOnly size="10px" id="pnum2">-
                             <input type="text" numberOnly size="10px" id="pnum3">
                             <br><span id="phoneRes"></span>
                             <input type="text" id="pnum" name=phone>
                   </td>
          </tr>
          
          <tr class="line">
                   <td>이메일(필수)</td>
                   <td><input type="text" id="mail1" onkeyup="emailmerge()">@<input type="text" size="10" id="mailRes" onkeyup="emailmerge()">
                             <select id="mail" onchange="checkEmail()">
                                      <option value="">직접입력</option>
                                      <option value="naver.com">naver.com</option>
                                      <option value="daum.net">daum.net</option>
                                      <option value="gmail.com">gmail.com</option>
                             </select>
                             <input type="button" value="인증번호 발송" id="randomNum">
                             <input type="text" id="summail" name="email"><br>
                            <!--  <span id="checkEmailnum"></span> -->
                             
                   </td>
                             
          </tr>
          <tr class="line">
                   <td>인증번호입력(필수)</td>
                   <td>
                             <input type="text" id="numCheck" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');" required>
                             <input type="button" id="matching" onclick="match()" value="확인">
                   </td>
          </tr>
         
          <tr class="linebottom">
                   <td colspan="3" align="center"><input type="submit" value="가입하기" id="SignUp"></td>
          </tr>
</table>
</div>
</div>
</form>
<c:import url="/include/footer"></c:import>
</body>
</html>

