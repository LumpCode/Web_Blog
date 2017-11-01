package com.blog.model.service;

import java.util.List;

import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;

public interface ArticleService {

    // 查询所有文章
    public List<Article> getAllArticleInfoService();

    // 获取指定公告
    public Notice getNoticeService();

    // 查询对应的用户的文章的信息
    public List<Article> getOneUserArticleInfoService(int uid);

    // 添加文章
    public boolean addArtService(Article art);

    // 查询文章的内容
    public Article getArticleService(int aid);

    // 删除文章
    public boolean delArticleService(int aid);

    // 更新文章
    public boolean updateArticleService(Article art);

    // 增加浏览量
    public boolean addClickNumService(int aid);
}
