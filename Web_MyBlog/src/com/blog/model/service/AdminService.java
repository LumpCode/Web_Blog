package com.blog.model.service;

import java.util.List;

import com.blog.model.entity.Admin;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;

public interface AdminService {
    // 管理员登陆
    public boolean loginAdminService(Admin admin);

    // 查询所有文章
    public List<Article> getAllArticleInfoService();

    // 查询文章的内容
    public Article getArticleService(int aid);

    // 删除文章
    public boolean delArticleService(int aid);
    
    //查寻所有公告
    public List<Notice> getAllNoticeInfoService();
    
    //获取 公告
    public Notice getOneNoticeService(int nid);
    
    //更新公告
    public boolean updateNoticeService(Notice notice);
    
    //添加公告
    public boolean addNoticeService(Notice notice);
    
    //查询所有用户信息
    public List<User> getAllUserInfoService();
    
    //查询一个用户的信息
    public User getOneUserInfoService(int uid);
    
    //管理用户信息
    public boolean updateUserInfoService(User user);
}
