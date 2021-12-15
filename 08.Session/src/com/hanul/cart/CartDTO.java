package com.hanul.cart;

public class CartDTO {
	private String name;	//제품명
	private int price, cnt;	//제품가격, 주문수량
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}		
}
