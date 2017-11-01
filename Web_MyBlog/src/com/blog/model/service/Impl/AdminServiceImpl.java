package com.blog.model.service.Impl;

import java.util.List;

import com.blog.model.dao.AdminDao;
import com.blog.model.dao.Impl.AdminDaoImpl;
import com.blog.model.entity.Admin;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;
import com.blog.model.service.AdminService;

public class AdminServiceImpl implements AdminService{
    AdminDao ad = new AdminDaoImpl();
    //管理员登陆
    public boolean loginAdminService(Admin admin){
	return ad.loginAdminDao(admin);
    }
    //查询所有文章
    public List<Article> getAllArticleInfoService() {
	return ad.getAllArticleInfoDao();
    }
    //查看文章内容
    public Article getArticleService(int aid) {
	return ad.getArticleDao(aid);
    }
    // 删除文章
    public boolean delArticleService(int aid) {
	return ad.delArticleDao(aid);
    }
    //查寻所有公告
    public List<Notice> getAllNoticeInfoService(){
	return ad.getAllNoticeInfoDao();
    }
    //获取 公告
    public Notice getOneNoticeService(int nid){
	return ad.getOneNoticeDao(nid);
    }
    //更新公告
    public boolean updateNoticeService(Notice notice){
	return ad.updateNoticeDao(notice);
    }
    //添加公告
    public boolean addNoticeService(Notice notice){
	return ad.addNoticeDao(notice);
    }
    
    //查询所有用户信息
    public List<User> getAllUserInfoService(){
	return ad.getAllUserInfoDao();
    }
    
    //查询一个用户的信息
    public User getOneUserInfoService(int uid){
	return ad.getOneUserInfoDao(uid);
    }
    
  //管理用户信息
    public boolean updateUserInfoService(User user){
	return ad.updateUserInfoDao(user);
    }
}
