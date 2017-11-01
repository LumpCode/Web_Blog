package com.blog.model.dao;

import com.blog.model.entity.User;

public interface UserDao {
	//��ѯ����Ա��½
	
	/**
	 * ��ѯ�û���½
	 * @param UserName: �û���
	 * @param pwd:����
	 */
	public User loginDao(String UserName,String pwd);
	
	/**
	 * �û�ע��,�����û��������ע��
	 * @param user:�û�����
	 */
	public boolean registerDao(User user);
	
	/**
	 * ��ѯ�û����Ƿ��ظ�
	 * @param nickName
	 * @return
	 */
	public boolean checkNickNameDao(String nickName);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean updateUserInfoDao(User user);
}
