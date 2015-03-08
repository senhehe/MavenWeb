package com.sen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sen.entity.Orderitem;
import com.sen.entity.Product;
import com.sen.service.ProductService;
import com.sen.util.Cart;

public class CartItemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService ps;
	private int productid;
	private int number;
	private InputStream inputStream;
	private Cart mycart;
	
	public String addCart() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		Orderitem oi = new Orderitem();
		Product p = ps.queryProductByID(productid);
		oi.setProduct(p);
		oi.setNumber(number);
		mycart = (Cart) session.get("cart");
		if(mycart==null) {
			mycart = new Cart();
		}
		mycart.add(productid,oi);
		session.put("cart", mycart);
		inputStream=new ByteArrayInputStream("<font color = \"red\"></font>".getBytes("utf-8"));
		return SUCCESS;
	}
	
	public String updateCart() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		mycart = ((Cart) session.get("cart"));   
		mycart.update(productid, number);
		return SUCCESS;
	}
	
	public String delCart() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		((Cart) session.get("cart")).del(productid);
		return SUCCESS;
	}
	
	public String removeCart() throws Exception  {
		Map<String, Object> session = ActionContext.getContext().getSession();
		((Cart) session.get("cart")).clear();
		return SUCCESS;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public Cart getMycart() {
		return mycart;
	}

	public void setMycart(Cart mycart) {
		this.mycart = mycart;
	}

	public ProductService getPs() {
		return ps;
	}

	public void setPs(ProductService ps) {
		this.ps = ps;
	}

}
