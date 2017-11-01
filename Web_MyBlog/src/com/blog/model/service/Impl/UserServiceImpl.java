package com.blog.model.service.Impl;

import com.blog.model.dao.Impl.UserDaoImpl;
import com.blog.model.entity.User;
import com.blog.model.service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl udi = new UserDaoImpl();
	// ��ѯ�û���½
	public User loginService(String UserName, String pwd) {
		return udi.loginDao(UserName, pwd);
	}
	//�û�ע��
	public boolean registerService(User user) {
		return udi.registerDao(user);
	}
	//��ѯ�û����Ƿ��ظ�
	public boolean checkNickService(String nickName) {
		return udi.checkNickNameDao(nickName);
	}
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean updateUserInfoService(User user){
	    return udi.updateUserInfoDao(user);
	}

}
