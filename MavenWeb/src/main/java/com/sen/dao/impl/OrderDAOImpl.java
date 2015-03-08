package com.sen.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sen.dao.OrderDAO;
import com.sen.entity.Order;

public class OrderDAOImpl extends HibernateDaoSupport implements OrderDAO {

	public void insert(Order o) throws Exception {
		this.getHibernateTemplate().save(o);
	}

	public void update(Order o) throws Exception {
		this.getHibernateTemplate().update(o);
	}

	public void delete(int id) throws Exception {
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Order.class, id));
	}

	public Order queryByid(int id) throws Exception {
		return this.getHibernateTemplate().get(Order.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Order> queryAll() throws Exception {
		return this.getHibernateTemplate().find("from Order");
	}

	@SuppressWarnings("unchecked")
	public List<Order> queryByun(String un) throws Exception {
		List<Order> ol= this.getHibernateTemplate().find("from Order where userid=? order by orderdate desc",new Object[]{un});
		return ol;
	}

}
