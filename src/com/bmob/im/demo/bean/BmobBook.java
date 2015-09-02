package com.bmob.im.demo.bean;

import cn.bmob.v3.BmobObject;

 
public class BmobBook extends BmobObject {
	private String bookName;
	private User bookOwner;
	
	private String bookImage;
	private String bookBorrower;
	private Boolean isReserved;
	
	public String getBookOwner() {
		return bookOwner;
	}

	public void setBookOwner(String bookOwner) {
		this.bookOwner = bookOwner;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookBorrower() {
		return bookBorrower;
	}

	public void setBookBorrower(String bookBorrower) {
		this.bookBorrower = bookBorrower;
	}

	public Boolean getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(Boolean isReserved) {
		this.isReserved = isReserved;
	}
 
	
	public String getBookName() {
		return bookName;
	}
	
 
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
