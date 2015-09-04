package com.bmob.im.demo.bean;

import java.util.ArrayList;

import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.datatype.BmobGeoPoint;
/*
 * create by xiangzhang
 * Date 2015.09.02
 */
public class Person extends BmobChatUser {
	private static final long serialVersionUID = 1L;

	/*added by xz
	 * 
	 */
	private String userName;
	private ArrayList<Book> bookList;   // published booklist contain both lent and unlent
	private ArrayList<Book> borrowedList;   // borrowed booklist
	
	
	
	public Boolean addBookList(Book item) {
		return bookList.add(item);
	}
	
	public Boolean removeBookList(Book item) {
		return bookList.remove(item);
	}
	
	public Boolean addborrowedList(Book item) {
		return borrowedList.add(item);
	}
	
	public Boolean removeborrowedList(Book item) {
		return borrowedList.remove(item);
	}
	
	
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public void setBooklist(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	public ArrayList<Book> getBorrowedList() {
		return borrowedList;
	}
	public void setBorrowedList(ArrayList<Book> borrowedList) {
		this.borrowedList = borrowedList;
	}
	
	
	
	/**
	 * //显示数据拼音的首字母
	 */	
	private String sortLetters;
	
	/**
	 * //性别-true-男
	 */
	private boolean sex;
	
	/**
	 * 地理坐标
	 */
	private BmobGeoPoint location;//
	
	public BmobGeoPoint getLocation() {
		return location;
	}
	public void setLocation(BmobGeoPoint location) {
		this.location = location;
	}
	public boolean getSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}
}
