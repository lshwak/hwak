function btn_click(obj) {
	
	if(obj=="login") {
		form1.action = "loginPost";
		form1.method = "post";
	} else {
		form1.action = "member";
		form1.method = "get";
	}
}

