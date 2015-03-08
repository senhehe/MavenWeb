package com.sen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sen.dao.ProductDAO;
import com.sen.entity.Product;

public class ProductDAOImpl extends HibernateDaoSupport implements ProductDAO{

	public void insert(Product p) throws Exception {
		this.getHibernateTemplate().save(p);
	}

	public void update(Product p) throws Exception {
		this.getHibernateTemplate().update(p);
	}

	public void delete(int id) throws Exception {
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Product.class, id));
	}

	public Product queryByid(int id) throws Exception {
		return this.getHibernateTemplate().get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> queryAll() throws Exception {
		return this.getHibernateTemplate().find("from Product");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Product> queryForPage(final int start,final int length) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query q = session.createQuery("from Product");
				q.setFirstResult(start);
				q.setMaxResults(length);
				List<Product> pl = q.list();
				return pl;
			}
		});
	}
	
	public int queryAllCount() throws Exception {
		return new Integer(this.getHibernateTemplate().find("select count(*) from Product").listIterator().next().toString()).intValue();
	}
	
}
