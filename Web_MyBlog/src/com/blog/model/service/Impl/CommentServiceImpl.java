package com.blog.model.service.Impl;

import java.util.List;

import com.blog.model.dao.CommentDao;
import com.blog.model.dao.Impl.CommentDaoImpl;
import com.blog.model.entity.Comment;
import com.blog.model.service.CommentService;

public class CommentServiceImpl implements CommentService{
    CommentDao cd = new CommentDaoImpl();
    /**
     * 查询文章的评论
     * @return　文章对应的所有评论
     */
    public List<Comment> getAllCommentService(int aid){
	return cd.getAllCommentDao(aid);
    }
    /**
     * 添加评论
     * @param com
     * @return
     */
    public boolean addCommentService(Comment com){
	return cd.addCommentDao(com);
    }
}
