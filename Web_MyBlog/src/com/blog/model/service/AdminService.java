package com.blog.model.service;

import java.util.List;

import com.blog.model.entity.Admin;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;

public interface AdminService {
    // ����Ա��½
    public boolean loginAdminService(Admin admin);

    // ��ѯ��������
    public List<Article> getAllArticleInfoService();

    // ��ѯ���µ�����
    public Article getArticleService(int aid);

    // ɾ������
    public boolean delArticleService(int aid);
    
    //��Ѱ���й���
    public List<Notice> getAllNoticeInfoService();
    
    //��ȡ ����
    public Notice getOneNoticeService(int nid);
    
    //���¹���
    public boolean updateNoticeService(Notice notice);
    
    //��ӹ���
    public boolean addNoticeService(Notice notice);
    
    //��ѯ�����û���Ϣ
    public List<User> getAllUserInfoService();
    
    //��ѯһ���û�����Ϣ
    public User getOneUserInfoService(int uid);
    
    //�����û���Ϣ
    public boolean updateUserInfoService(User user);
}
