package com.sen.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.sen.dao.UserDAO;
import com.sen.entity.User;
import com.sen.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO udao;

	public void addUser(com.sen.vo.User u)  throws Exception{
		if(udao.queryByid(u.getUsername()) == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			User user = new User();
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setSex(u.getSex());
			user.setBirthday(new Timestamp(sdf.parse(u.getBirthday()).getTime()));
			user.setEmail(u.getEmail());
			user.setType(1);
			udao.insert(user);
		}else {
			throw new Exception();
		}
	}

	public void delUser(String un)  throws Exception{
		if(udao.queryByid(un) != null) {
			udao.delete(un);
		}else {
			throw new Exception();
		}
	}

	public List<User> queryAllUser()  throws Exception{
		return udao.queryAll();
	}

	public User queryUserByID(String un)  throws Exception{
		return udao.queryByid(un);
	}

	public void updateUser(com.sen.vo.User u)  throws Exception{
		if(udao.queryByid(u.getUsername()) != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			User user = new User();
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setSex(u.getSex());
			user.setBirthday(new Timestamp(sdf.parse(u.getBirthday()).getTime()));
			user.setEmail(u.getEmail());
			user.setType(u.getType());
			udao.update(user);
		}else {
			throw new Exception();
		}
	}
	
	public int queryUserByUP(String un,String pw) throws Exception {
		return udao.queryByUP(un,pw);
	}

	public UserDAO getUdao() {
		return udao;
	}

	public void setUdao(UserDAO udao) {
		this.udao = udao;
	}

}
