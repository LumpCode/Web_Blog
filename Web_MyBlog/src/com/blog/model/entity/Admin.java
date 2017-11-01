package com.blog.model.entity;

public class Admin {
    private int adminId;
    private String adminName;
    private String adminPwd;
    private int noticeId;
    public Admin() {
	super();
    }
    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminPwd() {
        return adminPwd;
    }
    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
    public int getNoticeId() {
        return noticeId;
    }
    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }
    
}
