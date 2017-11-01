package com.blog.model.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blog.model.dao.UserDao;
import com.blog.model.entity.User;
import com.blog.model.utils.DBManager;

public class UserDaoImpl implements UserDao{
	//��ѯ�û���½
	public User loginDao(String UserName, String pwd) {
		User user = new User();
		Connection conn = DBManager.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from userInfo where userName= ? and pwd = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, UserName);
			pstm.setString(2, pwd);
			rs = pstm.executeQuery();
			if(rs.next()){
				user.setUserName(rs.getString("userName"));
				user.setPwd(rs.getString("pwd"));
				user.setNickName(rs.getString("nickName"));
				user.setQianMing(rs.getString("qianMing"));
				user.setEmail(rs.getString("email"));
				user.setUid(rs.getInt("uid"));
				user.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserDaoImpl��ѯ�û���½ʧ��");
		}finally{
			DBManager.closeAll(conn, rs, pstm);
		}
		return user;
	}

	//�û�ע��
	public boolean registerDao(User user) {
		boolean flag = false;
		String sql = "insert into userInfo(userName,pwd,nickName,email) values(?,?,?,?)";
		Object[] obj = {user.getUserName(),user.getPwd(),user.getNickName(),user.getEmail()};
		flag = DBManager.executeUpdate(sql, obj);
		return flag;
	}
	
	//��ѯ�û����Ƿ��ظ�
	public boolean checkNickNameDao(String nickName){
		boolean flag = true;
		Connection conn = DBManager.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from userInfo where nickName= ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nickName);
			rs = pstm.executeQuery();
			if(rs.next()){
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ�û����ظ�ʧ��");
		}finally{
			DBManager.closeAll(conn, rs, pstm);
		}
		return flag;
	}

	/**
	 * �����û���Ϣ
	 */
	public boolean updateUserInfoDao(User user) {
	    boolean flag = false;
	    String sql = "update userInfo set userName=?,pwd=?,nickName=?,qianMing=?,email=? where uid =?";
	    Object[] obj = {user.getUserName(),user.getPwd(),user.getNickName(),user.getQianMing(),user.getEmail(),user.getUid()};
	    flag = DBManager.executeUpdate(sql, obj);
	    return flag;
	}

}
