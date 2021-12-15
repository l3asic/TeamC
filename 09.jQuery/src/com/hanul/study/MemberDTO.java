package com.hanul.study;

import java.io.Serializable;

public class MemberDTO implements Serializable{	//객체의 직렬화
	//멤버변수(필드) 선언
	private String name, id, pw, addr, tel;
	private int age;
	
	//디폴트 생성자 메소드와 생성자 메소드 초기화 : 생략
	
	//Getters & Setters 메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
