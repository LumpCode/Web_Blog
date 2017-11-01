package com.blog.model.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.blog.model.dao.ArticleDao;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.utils.DBManager;
import com.blog.model.utils.MyTools;

public class ArticleDaoImpl implements ArticleDao {

     
    public List<Article> getAllArticleInfoDao() {
	//��������������
	getAllArtId();
	
	List<Article> alist = new ArrayList<Article>();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	// �·����������ǰ��
	String sql = "select * from article order by aid desc";
	try {
	    pstm = conn.prepareStatement(sql);
	    rs = pstm.executeQuery();
	    while (rs.next()) {
		Article art = new Article();
		art.setAid(rs.getInt("aid"));
		art.setTitle(rs.getString("title"));
		art.setContent(rs.getString("content"));
		art.setUserName(rs.getString("userName"));
		art.setHasRead(rs.getInt("hasRead"));
		art.setP_date(MyTools.changeTime(rs.getTimestamp("p_date")));
		art.setUid(rs.getInt("uid"));
		art.setTypeId(rs.getInt("typeId"));
		art.setClickNum(rs.getInt("clickNum"));
		alist.add(art);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ѯ����������Ϣʧ��");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return alist;
    }

    // ��ѯ��Ӧ���û������µ���Ϣ
    public List<Article> getOneUserArticleInfoDao(int uid) {
	//��������������
	getAllArtId();
	
	List<Article> alist = new ArrayList<Article>();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = "select * from article where uid = ? order by aid desc";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, uid);
	    rs = pstm.executeQuery();
	    while (rs.next()) {
		Article art = new Article();
		art.setAid(rs.getInt("aid"));
		art.setTitle(rs.getString("title"));
		art.setContent(rs.getString("content"));
		art.setUserName(rs.getString("userName"));
		art.setHasRead(rs.getInt("hasRead"));
		art.setP_date(MyTools.changeTime(rs.getTimestamp("p_date")));
		art.setUid(rs.getInt("uid"));
		art.setTypeId(rs.getInt("typeId"));
		art.setClickNum(rs.getInt("clickNum"));
		alist.add(art);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ѯ��Ӧ�û�������������Ϣʧ��");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return alist;
    }
    
    //��ѯ��������ID
    public void getAllArtId(){
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = "select aid from article";
	try {
	    pstm = conn.prepareStatement(sql);
	    rs = pstm.executeQuery();
	    while(rs.next()){
		updateHasRead(rs.getInt("aid"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ѯ��������IDʧ��");
	}
    }
    //����������
    public boolean updateHasRead(int aid){
	boolean flag = false;
	String sql= "update article set hasRead = (select COUNT(cmt_id) from comment where aid = ?) where aid = ?";
	Object[] obj = {aid,aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    
    
    // �������
    public boolean addArtDao(Article art) {
	boolean flag = false;
	String sql = "insert into article(title,content,uid,userName,p_date) values(?,?,?,?,?)";
	Object[] obj = { art.getTitle(), art.getContent(), art.getUid(),
		art.getUserName(), art.getP_date() };
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

    /**
     * ��ѯ��Ӧ��ŵ�������Ϣ
     * 
     * @param aid  ���±��
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
	String sql = "delete article where aid = ?";
	Object[] obj = {aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    
    /**
     * ��������
     */
    public boolean updateArticleDao(Article art){
	boolean flag = false;
	String sql = "update article set title=?,content=?,p_date=? where aid = ?";
	Object[] obj = {art.getTitle(),art.getContent(),art.getP_date(),art.getAid()};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    /**
     * ��ѯ�����
     * @param aid
     * @return
     */
    public int getClickNumDao(int aid){
	int clickNum = 0;
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = "select clickNum from article where aid = ?";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, aid);
	    rs = pstm.executeQuery();
	    if (rs.next()) {
		clickNum = rs.getInt("clickNum");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("��ȡ���µ����ʧ��!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return clickNum;
    }
    /**
     * ���������
     */
    public boolean addClickNumDao(int aid){
	boolean flag = false;
	int clickNum = getClickNumDao(aid)+1;
	String sql = "update article set clickNum = ? where aid = ?";
	Object[] obj = {clickNum,aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

    //��ȡָ������
    public Notice getNoticeDao() {
	Notice notice = new Notice();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql ="select * from notice where status = 1";
	try {
	    pstm = conn.prepareStatement(sql);
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

}
