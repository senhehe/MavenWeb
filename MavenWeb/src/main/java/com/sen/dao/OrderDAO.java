package com.sen.dao;

import java.util.List;

import com.sen.entity.Order;

public interface OrderDAO {
	public void insert(Order o) throws Exception;
	public void update(Order o) throws Exception;
	public void delete(int id) throws Exception;
	public Order queryByid(int id) throws Exception;
	public List<Order> queryAll() throws Exception;
	public List<Order> queryByun(String un) throws Exception;
}
