package com.blog.model.dao;

import java.util.List;

import com.blog.model.entity.Article;
import com.blog.model.entity.Notice;

public interface ArticleDao {
	//��ѯ����������Ϣ
	public List<Article> getAllArticleInfoDao();
	//��ȡָ������
	public Notice getNoticeDao();
	//��ѯ��Ӧ���û������µ���Ϣ
	public List<Article> getOneUserArticleInfoDao(int uid);
	//�������
	public boolean addArtDao(Article art);
	//��ѯ���µ�����
	public Article getArticleDao(int aid);
	//ɾ������
	public boolean delArticleDao(int aid);
	//��������
	public boolean updateArticleDao(Article art);
	//�鿴�����
	public int getClickNumDao(int aid);
	//���������
	public boolean addClickNumDao(int aid);
	
	
}
