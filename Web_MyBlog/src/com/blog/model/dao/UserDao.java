package com.blog.model.dao;

import com.blog.model.entity.User;

public interface UserDao {
	//查询管理员登陆
	
	/**
	 * 查询用户登陆
	 * @param UserName: 用户名
	 * @param pwd:密码
	 */
	public User loginDao(String UserName,String pwd);
	
	/**
	 * 用户注册,传入用户对象进入注册
	 * @param user:用户对象
	 */
	public boolean registerDao(User user);
	
	/**
	 * 查询用户名是否重复
	 * @param nickName
	 * @return
	 */
	public boolean checkNickNameDao(String nickName);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUserInfoDao(User user);
}
