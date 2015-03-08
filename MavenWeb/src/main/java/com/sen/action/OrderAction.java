package com.sen.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sen.entity.Order;
import com.sen.entity.Orderitem;
import com.sen.service.OrderItemService;
import com.sen.service.OrderService;
import com.sen.service.UserService;
import com.sen.util.Cart;

public class OrderAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService us;
	private OrderService os;
	private OrderItemService ois;
	private String linkman;
	private String address;
	private String phone;
	private int orderid;
	
	@SuppressWarnings("unchecked")
	public String saveOrder() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String un = (String) session.get("username");
		Cart c = (Cart) session.get("cart");
		if(c==null||c.getCart().isEmpty()) {
			return ERROR;
		}
		Order o = new Order();
		o.setUser(us.queryUserByID(un));
		o.setTotalprice(c.getTotalPrice());
		o.setOrderdate(new Timestamp(new Date().getTime()));
		o.setLinkman(linkman);
		o.setAddress(address);
		o.setPhone(phone);
		o.setStatus(1);
		
		Iterator<Orderitem> it = c.getCart().values().iterator();
		while(it.hasNext()) {
			Orderitem oi = (Orderitem) it.next();
			oi.setOrder(o);
			o.getOrderitems().add(oi);
		}
		os.addOrder(o);
		session.remove("cart");
		return SUCCESS;
	}
	
	public String viewOrder() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String un = (String) session.get("username");
		session.put("myorder", os.queryOrderByUN(un));
		return SUCCESS;
	}
	
	public String viewOrderItems() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		Map<Order,List<Orderitem>> viewoi = new HashMap<Order,List<Orderitem>>();
		List<Orderitem> loi = ois.queryOrderItemByOId(orderid);
		Order o = os.queryOrderByID(orderid);
		viewoi.put(o, loi);
		session.put("theitems", viewoi);
		return SUCCESS;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public OrderService getOs() {
		return os;
	}

	public void setOs(OrderService os) {
		this.os = os;
	}

	public OrderItemService getOis() {
		return ois;
	}

	public void setOis(OrderItemService ois) {
		this.ois = ois;
	}
	
}
