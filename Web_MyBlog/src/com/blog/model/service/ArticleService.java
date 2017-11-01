package com.blog.model.service;

import java.util.List;

import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;

public interface ArticleService {

    // ��ѯ��������
    public List<Article> getAllArticleInfoService();

    // ��ȡָ������
    public Notice getNoticeService();

    // ��ѯ��Ӧ���û������µ���Ϣ
    public List<Article> getOneUserArticleInfoService(int uid);

    // �������
    public boolean addArtService(Article art);

    // ��ѯ���µ�����
    public Article getArticleService(int aid);

    // ɾ������
    public boolean delArticleService(int aid);

    // ��������
    public boolean updateArticleService(Article art);

    // ���������
    public boolean addClickNumService(int aid);
}
