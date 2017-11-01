package com.blog.model.service.Impl;

import com.blog.model.dao.Impl.UserDaoImpl;
import com.blog.model.entity.User;
import com.blog.model.service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl udi = new UserDaoImpl();
	// 查询用户登陆
	public User loginService(String UserName, String pwd) {
		return udi.loginDao(UserName, pwd);
	}
	//用户注册
	public boolean registerService(User user) {
		return udi.registerDao(user);
	}
	//查询用户名是否重复
	public boolean checkNickService(String nickName) {
		return udi.checkNickNameDao(nickName);
	}
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUserInfoService(User user){
	    return udi.updateUserInfoDao(user);
	}

}
