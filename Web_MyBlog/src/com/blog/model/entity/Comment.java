package com.blog.model.entity;

public class Comment {
    private int cmt_id;
    private int aid;
    private String content;
    private int p_uid;
    private int uid;
    private String userName;
    private String cmtDate;
    public Comment() {
	super();
    }
    public int getCmt_id() {
        return cmt_id;
    }
    public void setCmt_id(int cmt_id) {
        this.cmt_id = cmt_id;
    }
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getP_uid() {
        return p_uid;
    }
    public void setP_uid(int p_uid) {
        this.p_uid = p_uid;
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
    public String getCmtDate() {
        return cmtDate;
    }
    public void setCmtDate(String cmtDate) {
        this.cmtDate = cmtDate;
    }
    
}
