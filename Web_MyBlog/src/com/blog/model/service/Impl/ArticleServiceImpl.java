package com.blog.model.service.Impl;

import java.util.List;

import com.blog.model.dao.ArticleDao;
import com.blog.model.dao.Impl.ArticleDaoImpl;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
    ArticleDao ad = new ArticleDaoImpl();

    // ��ѯ����������Ϣ
    public List<Article> getAllArticleInfoService() {
	return ad.getAllArticleInfoDao();
    }

    // ��ȡָ������
    public Notice getNoticeService(){
	return ad.getNoticeDao();
    }

    // ��ѯ��Ӧ���û������µ���Ϣ
    public List<Article> getOneUserArticleInfoService(int uid) {
	return ad.getOneUserArticleInfoDao(uid);
    }

    // �������
    public boolean addArtService(Article art) {
	return ad.addArtDao(art);
    }

    // ��ѯ���µ�����
    public Article getArticleService(int aid) {
	return ad.getArticleDao(aid);
    }

    // ɾ������
    public boolean delArticleService(int aid) {
	return ad.delArticleDao(aid);
    }

    // ���������
    public boolean addClickNumService(int aid) {
	return ad.addClickNumDao(aid);
    }

    // ��������
    public boolean updateArticleService(Article art) {
	return ad.updateArticleDao(art);
    }
}
