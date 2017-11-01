package com.blog.model.service;

import com.blog.model.entity.User;

public interface UserService {
	// 查询用户登陆
	public User loginService(String UserName, String pwd);
	
	//用户注册
	public boolean registerService(User user);
	
	//查询用户名是否重复
	public boolean checkNickService(String nickName);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUserInfoService(User user);
}
