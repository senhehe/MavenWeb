package com.sen.dao;

import java.util.List;

import com.sen.entity.Orderitem;

public interface OrderItemDAO {
	public void insert(Orderitem oi) throws Exception;
	public void update(Orderitem oi) throws Exception;
	public void delete(int id) throws Exception;
	public Orderitem queryByid(int id) throws Exception;
	public List<Orderitem> queryAll() throws Exception;
	public List<Orderitem> queryByoid(int id) throws Exception;
}
