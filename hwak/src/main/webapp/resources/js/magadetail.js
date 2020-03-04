

$(document).ready(function(){
	// 수정
	$("#modi").click(function(){
		$("#magaForm").attr("action","magamodify")
	})
	// 삭제
	$("#del").click(function(){
		$("#magaForm").attr("action","magadelete")
	})
})










