package com.blog.model.entity;

public class Notice {
    private int noticeId;
    private String noticeTitle;
    private String noticeDetail;
    private int status;
    public Notice() {
	super();
    }
   
    public Notice(String noticeTitle, String noticeDetail, int status) {
	super();
	this.noticeTitle = noticeTitle;
	this.noticeDetail = noticeDetail;
	this.status = status;
    }

    public Notice(int noticeId, String noticeTitle, String noticeDetail,
	    int status) {
	super();
	this.noticeId = noticeId;
	this.noticeTitle = noticeTitle;
	this.noticeDetail = noticeDetail;
	this.setStatus(status);
    }

    public int getNoticeId() {
        return noticeId;
    }
    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }
    public String getNoticeTitle() {
        return noticeTitle;
    }
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    public String getNoticeDetail() {
        return noticeDetail;
    }
    public void setNoticeDetail(String noticeDetail) {
        this.noticeDetail = noticeDetail;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }
    
}
