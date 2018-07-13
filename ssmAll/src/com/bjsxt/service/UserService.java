package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.User;

public interface UserService {
	
	/**
	 * 保存用户的方法
	 * @param user
	 * @return 新增用户的ID
	 */
	int saveUser(User user);
	/**
	 * 查询单个用户信息
	 * @param userId 用户ID
	 * @return
	 */
	User getUser(int userId);
	
	/**
	 * 修改用户的方法
	 * @param user
	 */
	void modifyUser(User user);
	
	void removeUser(int userId);
	
	List<User> getPaginatedUsers(int page, int rows);
	
	int getPageSum(int rows);
	
}
