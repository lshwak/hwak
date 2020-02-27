
var rannum="";	// 이메일인증난수 전역변수
//function rannum(data){}
/* 자바스크립트 */

// 아이디 중복체크
function checkId() {
     $.ajax({	
 		url : "idChk", // 보낼 url주소.
 		type : "post", //
 		dataType : "json", //dataType : 리턴을 받는 타입이json
 		data : {"id" : $("#idCheck").val()}, // 보낼 데이터
 		success : function(data) {
 			
 			if(data == 1) {
 				document.getElementById("idRes").innerHTML=
 				"이미 존재하는 아이디입니다.";
 				idRes.style.color = "red";
 				return false;
 			}
 				
 		}
 	})
 	
}

function form_check() {
	
	var result=true;
	var idRes = document.getElementById("idRes").innerHTML;
	var pwRes = document.getElementById("pwRes").innerHTML;
    var id = document.getElementById("idCheck").value;
	var pw = document.getElementById("pwCheck").value;
	var repw = document.getElementById("repwCheck").value;
	var name = document.getElementById("nameCheck").value.length;
	var phone = document.getElementById("pnum").value.length;
	var randomNum = document.getElementById("numCheck").value;
	
	// 아이디 체크
	if(idRes != "사용가능한 아이디입니다."){
		result=false;
		return result;
		document.getElementById("SignUp").disabled = false;
	}
	// 비밀번호 체크
	if(pwRes != "사용가능한 비밀번호입니다."){
		result=false;
		return result;
		document.getElementById("SignUp").disabled = false;
	}
	// 비밀번호 확인 체크
	if(pw != repw){
		result=false;
		return result;
		document.getElementById("SignUp").disabled = false;
	}
	// 이름길이 체크
	if (name > 12) {
		document.getElementById("nameRes").innerHTML=
            "최대 12자까지의 이름를 작성해주세요.";
		result=false;
		return result;
		document.getElementById("SignUp").disabled = false;
	}
	// 연락처 길이 체크
	if (phone > 11) {
		 document.getElementById("phoneRes").innerHTML=
             "최대 11자까지의 연락처를 작성해주세요.";
			result=false;
			return result;
		document.getElementById("SignUp").disabled = false;
	}
	// 인증번호 체크
	if (rannum != randomNum) {
		result=false;
		return result;
		document.getElementById("SignUp").disabled = false;
	}
	return result;
}

$(document).ready(function(){
	var idpt=RegExp(/^[a-zA-Z0-9_]{3,12}$/);
	//아이디 패턴,길이
	$("#idCheck").keyup(function(){
		if(!(idpt.test($("#idCheck").val()))) {
			$("#idRes").html("영문 대소문자, 숫자, (_)를 사용하여 3자 이상, 12자 이하만 입력하세요.");
			$("#idRes").css("color","red");
		} else {
			$("#idRes").html("사용가능한 아이디입니다.");
			$("#idRes").css("color","blue");
		}
	})
	
	
	// 비밀번호 길이 확인
	var pwpt=RegExp(/^[a-zA-Z0-9!@#$%^&*-_+=]{8,12}$/);
	$("#pwCheck").keyup(function(){
		if(!(pwpt.test($("#pwCheck").val()))) {
			$("#pwRes").html("영문 대소문자, 숫자, 특수문자를 사용하여 8자 이상 12자 이하로 입력하세요.");
			$("#pwRes").css("color","red");
		} else {
			$("#pwRes").html("사용가능한 비밀번호입니다.");
			$("#pwRes").css("color","blue");
		}
	})
	
	// 인증번호 발송 눌렀을 때
	$("#randomNum").click(function(){
		
		var one = document.getElementById("mail1").value
	    var two = document.getElementById("mailRes").value
	    document.getElementById("summail").value = (one +"@"+ two);
		var tomail = $("#summail").val();
	
		$.ajax({
			url : "mail",
			type : "post",
			dataType : "text",
			data : "tomail="+tomail,		//보낼데이터 이메일
			success : function(data){	// controller에서 만들어온 난수data
				//alert("ajax의 "+data);
				rannum=data;
				alert("인증번호가 전송되었습니다. 해당 메일 [ "+tomail+" ]에서 번호를 확인해주세요.");
				/*$("#checkEmailnum").html("<input type='text' id='numCheck'  required>"+
                             "<input type='button' id='matching' onclick='match()' value='확인'>");*/
			}
		})
		
	})
	
	// 연락처 두번째 입력상자에 숫자만...
	$("input:text[numberOnly]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	    
	    
	    var pone = document.getElementById("pnum1").value
	    var ptwo = document.getElementById("pnum2").value
	    var pthree = document.getElementById("pnum3").value
	    document.getElementById("pnum").value = (pone+ptwo+pthree);
	    
	});
})



// 비밀번호 재확인
function checkRepw() {
          // text안의 값을 받아와서 길이를 측정 후 변수에 넣음
          var Repwlen=document.getElementById("repwCheck").value;
          var Pwlen=document.getElementById("pwCheck").value;
        
          // if구문 길이가 8자 이상, 12자 이하면 repwRes에 출력.
          if(Repwlen == Pwlen) {
                   document.getElementById("repwRes").innerHTML=
                             "비밀번호가 일치합니다.";
                   repwRes.style.color = "blue";
          }else{
        	  document.getElementById("repwRes").innerHTML=
                   "비밀번호 확인을 위해 동일하게 입력해주세요.";
                   repwRes.style.color = "red";
                   return false;
          }
}


//입력한 이메일 값 합치기(직접입력)
function emailmerge(){
	//alert("aaaaaaaaa");
	var one = document.getElementById("mail1").value
    var two = document.getElementById("mailRes").value
    document.getElementById("summail").value = (one +"@"+ two);
}
// 이메일 선택 시 text에 넣기(직접입력이 아닌 경우)
function checkEmail() {
          // em변수에 mail을 넣고.
          var em = document.getElementById("mail").value
          // mailRes자리에 em을 넣겠다.
          document.getElementById("mailRes").value=em;
          // option에 op혹은 no가 mailRes자리에 들어가는데
          var no = document.getElementById("mailRes").value.length;
          var op = document.getElementById("mailRes").value.length;
         
          if(em ==no) { // mailRes자리가되는 em에 직접입력이 되면 수정가능
          document.getElementById("mailRes").readOnly=false;
          } else {                           // mailRes자리가되는 em에 no가 아닌 주소가 들어가면 readonly
                   document.getElementById("mailRes").readOnly=true;
          }
          
          var one = document.getElementById("mail1").value
          var two = document.getElementById("mailRes").value
          document.getElementById("summail").value = (one +"@"+ two);
}

// 연락처 select option
function phonemerge() {
	var pone = document.getElementById("pnum1").value
    var ptwo = document.getElementById("pnum2").value
    var pthree = document.getElementById("pnum3").value
    document.getElementById("pnum").value = (pone+ptwo+pthree);
}
// 발송버튼 눌렀을 때 인증번호 받기
var ran = 'trandom';           // 전역변수로 지정
/*function random() {
            // 지역변수
                   ran = Math.floor(Math.random()*10000)+10000;       // 다섯자리의 랜덤메소드.
          alert("인증번호 "+ran+"를 입력하세요");
}*/
// 번호확인버튼 눌렀을 때 인증번호 매칭
function match() {
		//alert(rannum)
          var nc = document.getElementById("numCheck").value    // 인증번호 입력
         // var nclen = document.getElementsById("numCheck").value.length;
          if(nc == "") {
        	  alert("인증실패");
          }else if(nc == rannum) {   // 입력한 값이 랜덤값과 같으면
                   alert("인증성공");      
          }else {                     // 입력한 값이 같지 않으면
                   alert("인증실패");
          }
}

//가입하기 submit버튼
//function checking() {
// 입력한 이메일 값 합치기
//       var one = document.getElementById("mail1").value
//       var two = document.getElementById("mailRes").value
//       document.getElementById("summail").value = (one +"@"+ two);
// 입력한 연락처 값 합치기
//       var pone = document.getElementById("pnum1").value
//       var ptwo = document.getElementById("pnum2").value
//       var pthree = document.getElementById("pnum3").value
//      document.getElementById("pnum").value = (pone+ptwo+pthree);       
//}





