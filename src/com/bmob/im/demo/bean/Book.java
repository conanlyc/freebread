package com.bmob.im.demo.bean;

import cn.bmob.v3.BmobObject;

public class Book extends BmobObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookName;
	private String bookAvater;
	private Person user;
	
	private Boolean canBorrow;    // user also can set this flag and the book can be borrow by others.
	private Person borrower;      //
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAvater() {
		return bookAvater;
	}
	public void setBookAvater(String bookAvater) {
		this.bookAvater = bookAvater;
	}
	public Person getUser() {
		return user;
	}
	public void setUser(Person user) {
		this.user = user;
	}
	public Boolean getCanBorrow() {
		return canBorrow;
	}
	public void setCanBorrow(Boolean canBorrow) {
		this.canBorrow = canBorrow;
	}
	public Person getBorrower() {
		return borrower;
	}
	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}

	
	

}
