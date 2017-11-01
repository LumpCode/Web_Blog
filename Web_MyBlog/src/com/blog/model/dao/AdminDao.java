package com.blog.model.dao;

import java.util.List;

import com.blog.model.entity.Admin;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;

public interface AdminDao {
    // ����Ա��½
    public boolean loginAdminDao(Admin admin);

    // ����Ա��ѯ��������
    public List<Article> getAllArticleInfoDao();

    // ��ѯ���µ�����
    public Article getArticleDao(int aid);
    
    //ɾ������
    public boolean delArticleDao(int aid);
    
    //��ѯ���й���
    public List<Notice> getAllNoticeInfoDao();
    
    //��ȡ ����
    public Notice getOneNoticeDao(int nid);
    
    //���¹���
    public boolean updateNoticeDao(Notice notice);
    
    //��ӹ���
    public boolean addNoticeDao(Notice notice);
    
    //��ѯ�����û���Ϣ
    public List<User> getAllUserInfoDao();
    
    //��ѯһ���û�����Ϣ
    public User getOneUserInfoDao(int uid);
    
    //�����û���Ϣ
    public boolean updateUserInfoDao(User user);
}
