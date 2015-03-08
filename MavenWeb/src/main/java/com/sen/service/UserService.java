package com.sen.service;

import java.util.List;

import com.sen.entity.User;

public interface UserService {
	public void addUser(com.sen.vo.User u) throws Exception;
	public void updateUser(com.sen.vo.User u) throws Exception;
	public void delUser(String un) throws Exception;
	public User queryUserByID(String un) throws Exception;
	public List<User> queryAllUser() throws Exception;
	public int queryUserByUP(String un,String pw) throws Exception;
}
