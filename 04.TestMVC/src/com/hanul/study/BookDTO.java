package com.hanul.study;

public class BookDTO {
    private String title	;
    private String name 	;
    private String isbn 	;
    private String comp 	;
    private int cost	    ;
    private int qty 	    ;
    private int price	    ;
    
    private int deleteAll;    
       
	public BookDTO() {
		super();
	}
	public BookDTO(String title, String name, String isbn, String comp, int cost, int qty) {
		super();
		this.title = title;
		this.name = name;
		this.isbn = isbn;
		this.comp = comp;
		this.cost = cost;
		this.qty = qty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = cost * qty;
	}
	public int getDeleteAll() {
		return deleteAll;
	}
	public void setDeleteAll(int deleteAll) {
		this.deleteAll = deleteAll;
	}
	
	
	

	
	
	
	
    
    
    
    
    
    
}
