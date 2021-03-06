package com.redbeet.s1.member;

public class MemberDTO {

	/*
	 * 1. 모든 멤버변수는 private
	 * 2. 변수명과 데이터타입은 컬럼과 동일하게
	 * 3. getter, setter 필요
	 * 4. 기본생성자 1개
	 */
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
