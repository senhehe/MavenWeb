package com.sen.dao;

import java.util.List;

import com.sen.entity.User;

public interface UserDAO {
	public void insert(User u) throws Exception;
	public void update(User u) throws Exception;
	public void delete(String un) throws Exception;
	public User queryByid(String un) throws Exception;
	public List<User> queryAll() throws Exception;
	public int queryByUP(String un,String pw) throws Exception;
}
