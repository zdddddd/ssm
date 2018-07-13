package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.User;

public interface UserMapper {
	
	void insertUser(User user);
	
	User selectUser(int userId);
	
	void updateUser(User user);
	
	void deleteUser(int userId);
	
	List<User> selectPageUsers(@Param("min") int min, @Param("rows") int rows);
	
	int selectPageCount(int rows);
}
