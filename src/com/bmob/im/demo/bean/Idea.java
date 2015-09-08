package com.bmob.im.demo.bean;

import cn.bmob.v3.BmobObject;

public class Idea extends BmobObject {
	/**
	 * FriendZone Sharing
	 */
	private static final long serialVersionUID = 1L;
	
	private User owner;
	private String content;
	private String pic;
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	

	
}
