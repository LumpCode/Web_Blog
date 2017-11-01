package com.blog.model.service;

import java.util.List;

import com.blog.model.entity.Comment;

public interface CommentService {
    /**
     * 查询文章的评论
     * @return　文章对应的所有评论
     */
    public List<Comment> getAllCommentService(int aid);
    
    /**
     * 添加评论
     * @param com
     * @return
     */
    public boolean addCommentService(Comment com);
}
