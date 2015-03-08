package com.sen.service;

import java.util.List;

import com.sen.entity.Order;

public interface OrderService {
	public void addOrder(Order o) throws Exception;
	public void updateOrder(Order o) throws Exception;
	public void delOrder(int id) throws Exception;
	public Order queryOrderByID(int id) throws Exception;
	public List<Order> queryAllOrder() throws Exception;
	public List<Order> queryOrderByUN(String un) throws Exception;
}
