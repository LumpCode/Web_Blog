package com.blog.model.dao;

import java.util.List;

import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;

public interface ArticleDao {
	//查询所有文章信息
	public List<Article> getAllArticleInfoDao();
	//获取指定公告
	public Notice getNoticeDao();
	//查询对应的用户的文章的信息
	public List<Article> getOneUserArticleInfoDao(int uid);
	//添加文章
	public boolean addArtDao(Article art);
	//查询文章的内容
	public Article getArticleDao(int aid);
	//删除文章
	public boolean delArticleDao(int aid);
	//更新文章
	public boolean updateArticleDao(Article art);
	//查看浏览量
	public int getClickNumDao(int aid);
	//增加浏览量
	public boolean addClickNumDao(int aid);
	
	
}
