package com.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public int saveUser(User user) {
		this.userMapper.insertUser(user);
		int userId = user.getUserId();
		return userId;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public User getUser(int userId) {
		return this.userMapper.selectUser(userId);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public void modifyUser(User user) {
		this.userMapper.updateUser(user);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public void removeUser(int userId) {
		this.userMapper.deleteUser(userId);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public List<User> getPaginatedUsers(int page, int rows) {
		List<User> users = this.userMapper.selectPageUsers((page - 1) * rows, rows);
		return users;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public int getPageSum(int rows) {
		return this.userMapper.selectPageCount(rows);
	}

}
