package com.blog.model.entity;

public class User {
	private String userName;
	private String pwd;
	private String nickName;
	private String qianMing;
	private String email;
	private int uid;
	private int status;
	public User() {
		super();
	}
	
	public User(int uid,String userName, String pwd, String nickName,
		 String email, int status) {
	    super();
	    this.uid = uid;
	    this.userName = userName;
	    this.pwd = pwd;
	    this.nickName = nickName;
	    this.email = email;
	    this.status = status;
	}
	
	public User(int uid,String userName, String pwd, String nickName,
		String qianMing, String email, int status) {
	    super();
	    this.uid = uid;
	    this.userName = userName;
	    this.pwd = pwd;
	    this.nickName = nickName;
	    this.qianMing = qianMing;
	    this.email = email;
	    this.status = status;
	}

	public User(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}
	public User(String userName, String pwd, String nickName, String qianMing,
			String email) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.nickName = nickName;
		this.qianMing = qianMing;
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getQianMing() {
		return qianMing;
	}
	public void setQianMing(String qianMing) {
		this.qianMing = qianMing;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getStatus() {
	    return status;
	}
	public void setStatus(int status) {
	    this.status = status;
	}
	
}
