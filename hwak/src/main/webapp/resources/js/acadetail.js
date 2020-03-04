$(document).ready(function(){
	// 수정
	$("#modi").click(function(){
		$("#acaForm").attr("action","acamodify")
	})
	// 삭제
	$("#del").click(function(){
		$("#acaForm").attr("action","acadelete")
	})
})






