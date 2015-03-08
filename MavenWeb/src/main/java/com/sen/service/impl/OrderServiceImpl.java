package com.sen.service.impl;

import java.util.List;

import com.sen.dao.OrderDAO;
import com.sen.entity.Order;
import com.sen.service.OrderService;


public class OrderServiceImpl implements OrderService{
	private OrderDAO odao;

	public List<Order> queryOrderByUN(String un) throws Exception {
		return odao.queryByun(un);
	}

	public void addOrder(Order o) throws Exception {
		odao.insert(o);
	}

	public void updateOrder(Order o) throws Exception {
		if(odao.queryByid(o.getId()) != null) {
			odao.update(o);
		}else {
			throw new Exception();
		}
	}

	public void delOrder(int id) throws Exception {
		if(odao.queryByid(id) != null) {
			odao.delete(id);
		}else {
			throw new Exception();
		}
	}

	public Order queryOrderByID(int id) throws Exception {
		return odao.queryByid(id);
	}

	public List<Order> queryAllOrder() throws Exception {
		return odao.queryAll();
	}

	public OrderDAO getOdao() {
		return odao;
	}

	public void setOdao(OrderDAO odao) {
		this.odao = odao;
	}

}
