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
	//更新所有评论数
	getAllArtId();
	
	List<Article> alist = new ArrayList<Article>();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	// 新发表的文章在前面
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
	    System.out.println("查询所有文章信息失败");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return alist;
    }

    // 查询对应的用户的文章的信息
    public List<Article> getOneUserArticleInfoDao(int uid) {
	//更新所有评论数
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
	    System.out.println("查询对应用户的所有文章信息失败");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return alist;
    }
    
    //查询所有文章ID
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
	    System.out.println("查询所有文章ID失败");
	}
    }
    //更新评论数
    public boolean updateHasRead(int aid){
	boolean flag = false;
	String sql= "update article set hasRead = (select COUNT(cmt_id) from comment where aid = ?) where aid = ?";
	Object[] obj = {aid,aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    
    
    // 添加文章
    public boolean addArtDao(Article art) {
	boolean flag = false;
	String sql = "insert into article(title,content,uid,userName,p_date) values(?,?,?,?,?)";
	Object[] obj = { art.getTitle(), art.getContent(), art.getUid(),
		art.getUserName(), art.getP_date() };
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

    /**
     * 查询对应编号的文章信息
     * 
     * @param aid  文章编号
     * @return art 文章内容
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
	    System.out.println("读取文章内容失败!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return art;
    }
    
    /**
     * 删除文章
     * @param aid 文章编号
     * @return 成功返回ture,失败返回false
     */
    public boolean delArticleDao(int aid){
	boolean flag = false;
	String sql = "delete article where aid = ?";
	Object[] obj = {aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    
    /**
     * 更新文章
     */
    public boolean updateArticleDao(Article art){
	boolean flag = false;
	String sql = "update article set title=?,content=?,p_date=? where aid = ?";
	Object[] obj = {art.getTitle(),art.getContent(),art.getP_date(),art.getAid()};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }
    /**
     * 查询点击率
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
	    System.out.println("获取文章点击量失败!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return clickNum;
    }
    /**
     * 增加浏览量
     */
    public boolean addClickNumDao(int aid){
	boolean flag = false;
	int clickNum = getClickNumDao(aid)+1;
	String sql = "update article set clickNum = ? where aid = ?";
	Object[] obj = {clickNum,aid};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

    //获取指定公告
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
	    System.out.println("读取公告失败!");
	} finally {
	    DBManager.closeAll(conn, rs, pstm);
	}
	return notice;
    }

}
