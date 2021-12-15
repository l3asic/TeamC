package com.hanul.member;

import java.io.Serializable;

public class MemberDTO implements Serializable{	//직렬화 : 멤버변수들을 바이트코드로 변환
	//① 멤버변수 선언
	private String name;
	private String id;
	private String pw;
	private int age;
	private String addr;
	
	//② 디폴트 생성자 메소드
	public MemberDTO() {}

	//③ 생성자 메소드 초기화
	public MemberDTO(String name, String id, String pw, int age, String addr) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.addr = addr;
	}

	//④ Getters & Setters 메소드
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
