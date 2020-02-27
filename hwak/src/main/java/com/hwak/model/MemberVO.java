package com.hwak.model;

public class MemberVO {
	/*회원가입*/
	private String id;	// 아이디
	private String password;	// 비밀번호
	private String name;	// 이름
	private String email;	// 이메일
	private String phone;	// 연락처
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
}