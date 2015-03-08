package com.sen.service.impl;

import java.util.List;

import com.sen.dao.OrderItemDAO;
import com.sen.entity.Orderitem;
import com.sen.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	private OrderItemDAO oidao;

	public List<Orderitem> queryOrderItemByOId(int id) throws Exception {
		return oidao.queryByoid(id);
	}

	public void addOrderItem(Orderitem oi) throws Exception {
		oidao.insert(oi);
	}

	public void updateOrderItem(Orderitem oi) throws Exception {
		if(oidao.queryByid(oi.getId()) != null) {
			oidao.update(oi);
		}else {
			throw new Exception();
		}
	}

	public void delOrderItem(int id) throws Exception {
		if(oidao.queryByid(id) != null) {
			oidao.delete(id);
		}else {
			throw new Exception();
		}
	}

	public Orderitem queryOrderItemByID(int id) throws Exception {
		return oidao.queryByid(id);
	}

	public List<Orderitem> queryAllOrderItem() throws Exception {
		return oidao.queryAll();
	}

	public OrderItemDAO getOidao() {
		return oidao;
	}

	public void setOidao(OrderItemDAO oidao) {
		this.oidao = oidao;
	}

}
