package com.hwak.model;

public class LoginVO {
	private String logid;
	private String logpassword;
	
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getLogpassword() {
		return logpassword;
	}
	public void setLogpassword(String logpassword) {
		this.logpassword = logpassword;
	}
	
	@Override
	public String toString() {
		return "LoginVO [logid=" + logid + ", logpassword=" + logpassword + "]";
	}
	
}
