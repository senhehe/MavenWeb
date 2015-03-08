package com.sen.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sen.dao.OrderItemDAO;
import com.sen.entity.Orderitem;

public class OrderItemDAOImpl extends HibernateDaoSupport implements OrderItemDAO {

	public void insert(Orderitem oi) throws Exception {
		this.getHibernateTemplate().save(oi);
	}

	public void update(Orderitem oi) throws Exception {
		this.getHibernateTemplate().update(oi);
	}

	public void delete(int id) throws Exception {
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Orderitem.class, id));
	}

	public Orderitem queryByid(int id) throws Exception {
		return this.getHibernateTemplate().get(Orderitem.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Orderitem> queryAll() throws Exception {
		return this.getHibernateTemplate().find("from Orderitem");
	}

	@SuppressWarnings("unchecked")
	public List<Orderitem> queryByoid(int id) throws Exception {
		List<Orderitem> oil = this.getHibernateTemplate().find("from Orderitem where orderid=?",new Object[]{id});
		return oil;
	}

}
