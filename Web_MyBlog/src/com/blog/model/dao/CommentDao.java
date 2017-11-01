package com.blog.model.dao;

import java.util.List;

import com.blog.model.entity.Comment;

public interface CommentDao {
    /**
     * 查询文章的评论
     * @return　文章对应的所有评论
     */
    public List<Comment> getAllCommentDao(int aid);
    
    /**
     * 添加评论
     * @param com 文章
     * @return
     */
    public boolean addCommentDao(Comment com);
    
}
