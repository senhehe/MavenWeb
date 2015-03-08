package com.sen.service;

import java.util.List;

import com.sen.entity.Orderitem;

public interface OrderItemService {
	public void addOrderItem(Orderitem oi) throws Exception;
	public void updateOrderItem(Orderitem oi) throws Exception;
	public void delOrderItem(int id) throws Exception;
	public Orderitem queryOrderItemByID(int id) throws Exception;
	public List<Orderitem> queryAllOrderItem() throws Exception;
	public List<Orderitem> queryOrderItemByOId(int id) throws Exception;
}
