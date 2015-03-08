package com.sen.dao;

import java.util.List;

import com.sen.entity.Product;

public interface ProductDAO {
	public void insert(Product p) throws Exception;
	public void update(Product p) throws Exception;
	public void delete(int id) throws Exception;
	public Product queryByid(int id) throws Exception;
	public List<Product> queryAll() throws Exception;
	public int queryAllCount() throws Exception;
	public List<Product> queryForPage(final int start,final int length) throws Exception;
}
