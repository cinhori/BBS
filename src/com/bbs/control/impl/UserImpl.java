package com.bbs.control.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bbs.bean.User;
import com.bbs.control.inter.UserInter;
import com.bbs.util.DBUtil;

public class UserImpl implements UserInter {

	public boolean register(User user) {

		Connection connection = DBUtil.getConn();
		String sql = "insert into user(username, userpassword, id) values (?, ?, null)";// sql
		PreparedStatement preparedStatement = null;
		boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername() + "");
			preparedStatement.setString(2, user.getPassword() + "");
			int isOk = preparedStatement.executeUpdate(); //鎵цexecuteUpdate()鏂规硶:杩欓噷鏄痷pdate鏁版嵁鐩稿綋浜庢洿鏂般�佹彃鍏�
			if (isOk > 0) {
				return !flag;
			} else {
				return flag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(connection, null, preparedStatement, null);
		return flag;
	}

	public User login(String username, String password) {
		Connection connection = DBUtil.getConn();
		String sql = "select * from user where username = ? and userpassword = ? ";// 缂栧啓sql璇彞锛岀涓�涓瓧娈典笉闇�瑕佹彃鍏ワ紝鏄嚜鍔ㄥ鍔犵殑
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username + "");
			preparedStatement.setString(2, password + "");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setUserId(rs.getInt("id"));
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(connection, preparedStatement, preparedStatement, null);
		return null;
		
	}

	public boolean logout(String username) {
		return false;
	}

}
