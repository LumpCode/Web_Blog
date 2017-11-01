package com.blog.model.entity;

public class Article {
	private int aid;
	private String title;
	private String content;
	private int uid;
	private String userName;
	private int hasRead;
	private String p_date;
	private int typeId;
	private int clickNum;
	public Article() {
		super();
	}
	public Article(String title, String content, int uid, String userName,
			int hasRead, String p_date, int typeId, int clickNum) {
		super();
		this.title = title;
		this.content = content;
		this.uid = uid;
		this.userName = userName;
		this.hasRead = hasRead;
		this.p_date = p_date;
		this.typeId = typeId;
		this.clickNum = clickNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getHasRead() {
		return hasRead;
	}
	public void setHasRead(int hasRead) {
		this.hasRead = hasRead;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getClickNum() {
		return clickNum;
	}
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
}
