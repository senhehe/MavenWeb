package com.sen.service.impl;

import java.util.List;

import com.sen.dao.ProductDAO;
import com.sen.entity.Product;
import com.sen.service.ProductService;
import com.sen.util.PageBean;

public class ProductServiceImpl implements ProductService {
	private ProductDAO pdao;

	public void addProduct(Product p) throws Exception {
		pdao.insert(p);
	}

	public void updateProduct(Product p) throws Exception {
		if(pdao.queryByid(p.getId()) != null) {
			pdao.update(p);
		}else {
			throw new Exception();
		}
	}

	public void delProduct(int id) throws Exception {
		if(pdao.queryByid(id) != null) {
			pdao.delete(id);
		}else {
			throw new Exception();
		}
	}

	public Product queryProductByID(int id) throws Exception {
		return pdao.queryByid(id);
	}

	public List<Product> queryAllProduct() throws Exception {
		return pdao.queryAll();
	}

	public PageBean queryForPage(int pagesize, int pagenow) throws Exception {
		int allRow = pdao.queryAllCount();
        int totalPage = PageBean.countTotalPage(pagesize, allRow);
        final int length = pagesize;
        final int currentPage = PageBean.countCurrentPage(pagenow);
        final int start = PageBean.startRow(pagesize, currentPage);
        List<Product> list = pdao.queryForPage(start, length);
        
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pagesize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}

	public ProductDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}

}
