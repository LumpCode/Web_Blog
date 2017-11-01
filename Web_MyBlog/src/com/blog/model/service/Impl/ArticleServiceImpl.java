package com.blog.model.service.Impl;

import java.util.List;

import com.blog.model.dao.ArticleDao;
import com.blog.model.dao.Impl.ArticleDaoImpl;
import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;
import com.blog.model.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
    ArticleDao ad = new ArticleDaoImpl();

    // 查询所有文章信息
    public List<Article> getAllArticleInfoService() {
	return ad.getAllArticleInfoDao();
    }

    // 获取指定公告
    public Notice getNoticeService(){
	return ad.getNoticeDao();
    }

    // 查询对应的用户的文章的信息
    public List<Article> getOneUserArticleInfoService(int uid) {
	return ad.getOneUserArticleInfoDao(uid);
    }

    // 添加文章
    public boolean addArtService(Article art) {
	return ad.addArtDao(art);
    }

    // 查询文章的内容
    public Article getArticleService(int aid) {
	return ad.getArticleDao(aid);
    }

    // 删除文章
    public boolean delArticleService(int aid) {
	return ad.delArticleDao(aid);
    }

    // 增加浏览量
    public boolean addClickNumService(int aid) {
	return ad.addClickNumDao(aid);
    }

    // 更新文章
    public boolean updateArticleService(Article art) {
	return ad.updateArticleDao(art);
    }
}
