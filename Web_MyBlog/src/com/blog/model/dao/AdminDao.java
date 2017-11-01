package com.blog.model.dao;

import java.util.List;

import com.blog.model.entity.Admin;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;

public interface AdminDao {
    // 管理员登陆
    public boolean loginAdminDao(Admin admin);

    // 管理员查询所有文章
    public List<Article> getAllArticleInfoDao();

    // 查询文章的内容
    public Article getArticleDao(int aid);
    
    //删除文章
    public boolean delArticleDao(int aid);
    
    //查询所有公告
    public List<Notice> getAllNoticeInfoDao();
    
    //获取 公告
    public Notice getOneNoticeDao(int nid);
    
    //更新公告
    public boolean updateNoticeDao(Notice notice);
    
    //添加公告
    public boolean addNoticeDao(Notice notice);
    
    //查询所有用户信息
    public List<User> getAllUserInfoDao();
    
    //查询一个用户的信息
    public User getOneUserInfoDao(int uid);
    
    //管理用户信息
    public boolean updateUserInfoDao(User user);
}
