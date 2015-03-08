package com.sen.service;

import java.util.List;

import com.sen.entity.Product;
import com.sen.util.PageBean;

public interface ProductService {
	public void addProduct(Product p) throws Exception;
	public void updateProduct(Product p) throws Exception;
	public void delProduct(int id) throws Exception;
	public Product queryProductByID(int id) throws Exception;
	public List<Product> queryAllProduct() throws Exception;
	public PageBean queryForPage(int pagesize,int pagenow) throws Exception;
}
