package com.blog.model.service;

import java.util.List;

import com.blog.model.entity.Comment;

public interface CommentService {
    /**
     * ��ѯ���µ�����
     * @return�����¶�Ӧ����������
     */
    public List<Comment> getAllCommentService(int aid);
    
    /**
     * �������
     * @param com
     * @return
     */
    public boolean addCommentService(Comment com);
}
