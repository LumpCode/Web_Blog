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
    //����Ա��½
    public boolean loginAdminService(Admin admin){
	return ad.loginAdminDao(admin);
    }
    //��ѯ��������
    public List<Article> getAllArticleInfoService() {
	return ad.getAllArticleInfoDao();
    }
    //�鿴��������
    public Article getArticleService(int aid) {
	return ad.getArticleDao(aid);
    }
    // ɾ������
    public boolean delArticleService(int aid) {
	return ad.delArticleDao(aid);
    }
    //��Ѱ���й���
    public List<Notice> getAllNoticeInfoService(){
	return ad.getAllNoticeInfoDao();
    }
    //��ȡ ����
    public Notice getOneNoticeService(int nid){
	return ad.getOneNoticeDao(nid);
    }
    //���¹���
    public boolean updateNoticeService(Notice notice){
	return ad.updateNoticeDao(notice);
    }
    //��ӹ���
    public boolean addNoticeService(Notice notice){
	return ad.addNoticeDao(notice);
    }
    
    //��ѯ�����û���Ϣ
    public List<User> getAllUserInfoService(){
	return ad.getAllUserInfoDao();
    }
    
    //��ѯһ���û�����Ϣ
    public User getOneUserInfoService(int uid){
	return ad.getOneUserInfoDao(uid);
    }
    
  //�����û���Ϣ
    public boolean updateUserInfoService(User user){
	return ad.updateUserInfoDao(user);
    }
}
