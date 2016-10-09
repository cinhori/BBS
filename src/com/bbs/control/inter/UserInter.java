package com.bbs.control.inter;

import com.bbs.bean.User;

public interface UserInter {
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
	
	/**
	 * 退出
	 * @param username
	 * @return
	 */
	public boolean logout(String username);
}
