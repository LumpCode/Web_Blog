package com.blog.model.service;

import com.blog.model.entity.User;

public interface UserService {
	// ��ѯ�û���½
	public User loginService(String UserName, String pwd);
	
	//�û�ע��
	public boolean registerService(User user);
	
	//��ѯ�û����Ƿ��ظ�
	public boolean checkNickService(String nickName);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean updateUserInfoService(User user);
}
