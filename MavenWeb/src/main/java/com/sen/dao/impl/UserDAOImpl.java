package com.sen.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sen.dao.UserDAO;
import com.sen.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	public void delete(String un) throws Exception {
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(User.class, un));
	}

	public void insert(User u) throws Exception {
		this.getHibernateTemplate().save(u);
	}

	@SuppressWarnings("unchecked")
	public List<User> queryAll() throws Exception {
		return this.getHibernateTemplate().find("from User");
	}

	public User queryByid(String un) throws Exception {
		return this.getHibernateTemplate().get(User.class, un);
	}

	public void update(User u) throws Exception {
		this.getHibernateTemplate().update(u);
	}
	
	@SuppressWarnings("unchecked")
	public int queryByUP(String un,String pw) throws Exception {
		User ue = new User();
		ue.setUsername(un);
		ue.setPassword(pw);
		List<User> lu = this.getHibernateTemplate().findByExample(ue);
		if(lu.size()>0) {
			return lu.get(0).getType();
		}else {
			return 0;
		}
	}

}
