package com.blog.model.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blog.model.dao.AdminDao;
import com.blog.model.entity.Admin;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.entity.User;
import com.blog.model.utils.DBManager;

public class AdminDaoImpl implements AdminDao {
    // ����Ա��½
    public boolean loginAdminDao(Admin admin) {
	boolean flag = false;
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = "select count(*) from admin where adminName=? and adminPwd=?";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setString(1, admin.getAdminName());
	    pstm.setString(2, admin.getAdminPwd());
	    rs = pstm.executeQuery();
	    if (rs.next()) {
		if (rs.getInt(1) == 1) {
		    flag = true;
		} else {
		    flag = false;
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ѯ����Ա��½ʧ��!");
	}
	return flag;
    }

    // ��ѯ��������
    public List<Article> getAllArticleInfoDao() {
	List<Article> alist = new ArticleDaoImpl().getAllArticleInfoDao();
	return alist;
    }

    /**
     * ��ѯ��Ӧ��ŵ�������Ϣ
     * @param aid ���±��
     * @return art ��������
     */
    public Article getArticleDao(int aid) {
	Article art = new Article();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = "select title,content,userName from article where aid = ?";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, aid);
	    rs = pstm.executeQuery();
	    if (rs.next()) {
		art.setAid(aid);
		art.setTitle(rs.getString("title"));
		art.setContent(rs.getString("content"));
		art.setUserName(rs.getString("userName"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ȡ��������ʧ��!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return art;
    }
    
    /**
     * ɾ������
     * @param aid ���±��
     * @return �ɹ�����ture,ʧ�ܷ���false
     */
    public boolean delArticleDao(int aid){
	boolean flag = false;
	String sql = "delete article where aid=?";
	Object[] obj = {aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

    /**
     * ��ѯ���й���
     */
    public List<Notice> getAllNoticeInfoDao() {
	List<Notice> Nlist = new ArrayList<Notice>();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql ="select * from notice";
	try {
	    pstm = conn.prepareStatement(sql);
	    rs = pstm.executeQuery();
	    while(rs.next()) {
		Notice notice = new Notice(rs.getInt("noticeId"),
					rs.getString("noticeTitle"),
					rs.getString("noticeDetail"),
					rs.getInt("status"));
		Nlist.add(notice);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ȡ����ʧ��!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return Nlist;
    }
    //�༭����
    public Notice getOneNoticeDao(int nid){
	Notice notice = new Notice();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql ="select * from notice where noticeId = ?";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, nid);
	    rs = pstm.executeQuery();
	    if(rs.next()) {
		notice.setNoticeId(rs.getInt("noticeId"));
		notice.setNoticeTitle(rs.getString("noticeTitle"));
		notice.setNoticeDetail(rs.getString("noticeDetail"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ȡ����ʧ��!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return notice;
    }

    //���¹���
    public boolean updateNoticeDao(Notice notice) {
	boolean flag = false;
	String sql = "update notice set noticeTitle=?,noticeDetail=?,status=? where noticeId=?";
	Object[] obj = {notice.getNoticeTitle(),notice.getNoticeDetail(),notice.getStatus(),notice.getNoticeId()};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

    //��ӹ���
    public boolean addNoticeDao(Notice notice) {
	boolean flag = false;
	String sql = "insert into notice values(?,?,?)";
	Object[] obj = {notice.getNoticeTitle(),notice.getNoticeDetail(),notice.getStatus()};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    //��ѯ�����û���Ϣ
    public List<User> getAllUserInfoDao(){
	List<User> ulist = new ArrayList<User>();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql ="select * from userInfo";
	try {
	    pstm = conn.prepareStatement(sql);
	    rs = pstm.executeQuery();
	    while(rs.next()) {
		User user = new User(
			rs.getInt("uid"),
			rs.getString("userName"),
			rs.getString("pwd"),
			rs.getString("nickName"),
			rs.getString("qianMing"),
			rs.getString("email"),
			rs.getInt("status")
			);
		ulist.add(user);
		
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ȡallUserInfoʧ��!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return ulist;
    }
    //��ѯһ���û�����Ϣ
    public User getOneUserInfoDao(int uid){
	User user = null;
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql ="select * from userInfo where uid = ?";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, uid);
	    rs = pstm.executeQuery();
	    if(rs.next()) {
		user = new User(
			rs.getInt("uid"),
			rs.getString("userName"),
			rs.getString("pwd"),
			rs.getString("nickName"),
			rs.getString("qianMing"),
			rs.getString("email"),
			rs.getInt("status")
			);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ȡuserInfoʧ��!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return user;
    }
    //�����û���Ϣ
    public boolean updateUserInfoDao(User user){
	boolean flag = false;
	String sql = "update userInfo set userName=?,pwd=?,nickName=?,email=?,status=? where uid = ?";
	Object[] obj = {user.getUserName(),user.getPwd(),user.getNickName(),user.getEmail(),user.getStatus(),user.getUid()};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
}
