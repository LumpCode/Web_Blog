package com.blog.model.dao;

import java.util.List;

import com.blog.model.entity.Comment;

public interface CommentDao {
    /**
     * ��ѯ���µ�����
     * @return�����¶�Ӧ����������
     */
    public List<Comment> getAllCommentDao(int aid);
    
    /**
     * �������
     * @param com ����
     * @return
     */
    public boolean addCommentDao(Comment com);
    
}
