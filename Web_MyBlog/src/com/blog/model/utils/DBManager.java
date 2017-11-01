package com.blog.model.utils;

import java.sql.*;

public class DBManager {
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;DataBaseName=db_Web_MyBlog";
	private static final String userName = "sa";
	private static final String pwd = "123456";

	/* 获取数据库的连接 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("获取连接失败");
			e.printStackTrace();
		}
		return conn;
	}

	/* 增删改的封装 */
	public static boolean executeUpdate(String sql, Object[] obj) {
		boolean flag = false;
		Connection conn = getConnection();
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			for (int i = 0; obj != null & i < obj.length; i++) {
				stm.setObject(i + 1, obj[i]);
			}
			int num = stm.executeUpdate();
			if (num > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, null, stm);
		}
		return flag;
	}

	public static void closeAll(Connection conn, ResultSet rs, Statement stm) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

		}
	}
}
