package com.hanul.study;

public class UserDTO {
	String id;
	String name;
	int score;
	String ox;
	String pass;
	int cnt;

	public UserDTO() {
		super();
	}
	public UserDTO(String ox) {
		super();
	}
	public UserDTO(String id, String name, int score, String ox, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.ox = ox;
		this.pass = pass;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getOx() {
		return ox;
	}

	public void setOx(String ox) {
		this.ox = ox;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	

}
