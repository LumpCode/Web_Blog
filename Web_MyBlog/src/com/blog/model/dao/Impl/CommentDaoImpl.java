package com.blog.model.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blog.model.dao.CommentDao;
import com.blog.model.entity.Comment;
import com.blog.model.utils.DBManager;

public class CommentDaoImpl implements CommentDao{

    /**
     *　查询文章下的所有评论
     */
    public List<Comment> getAllCommentDao(int aid) {
	List<Comment> clist = new ArrayList<Comment>();
	Connection conn = DBManager.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = "select * from comment where aid = ? ";
	try {
	    pstm = conn.prepareStatement(sql);
	    pstm.setInt(1, aid);
	    rs = pstm.executeQuery();
	    while(rs.next()){
		Comment comm = new Comment();
		comm.setCmt_id(rs.getInt("cmt_id"));
		comm.setAid(rs.getInt("aid"));
		comm.setContent(rs.getString("content"));
		comm.setP_uid(rs.getInt("p_uid"));
		comm.setUid(rs.getInt("uid"));
		comm.setUserName(rs.getString("userName"));
		comm.setCmtDate(rs.getString("cmtDate"));
		clist.add(comm);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("查询评论失败！");
	}finally{
	    
	}
	return clist;
    }

    /**
     * 添加评论
     */
    public boolean addCommentDao(Comment com) {
	boolean flag = false;
	String sql = "insert into comment(aid,content,userName,cmtDate) values(?,?,?,?)";
	Object[] obj = {com.getAid(),com.getContent(),com.getUserName(),com.getCmtDate()};
	flag = DBManager.executeUpdate(sql, obj);
	return flag;
    }

}
