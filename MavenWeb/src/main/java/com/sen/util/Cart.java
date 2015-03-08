package com.sen.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sen.entity.Orderitem;
import com.sen.entity.Product;

public class Cart {
	private Map<Integer,Orderitem> cart;
	
	public Cart() {
		cart = new HashMap<Integer,Orderitem>();
	}
	
	public void add(int n,Orderitem oi) {
		cart.put(n, oi);
	}
	
	public void update(int productid,int number) {
		if(cart.containsKey(productid)) {
			Orderitem oi = cart.get(productid);
			oi.setNumber(number);
			cart.put(productid, oi);
		}
	}
	
	public void del(int n) {
		if(cart.containsKey(n)) {
			cart.remove(n);
		}
		
	}
	
	public void clear() {
		if(!cart.isEmpty()) {
			cart.clear();
		}
	}
	
	public boolean isempty() {
		return cart.isEmpty();
	}
	
	public double getTotalPrice() {
		double totalprice=0.00;
		Iterator<Orderitem> iterator = (Iterator<Orderitem>) cart.values().iterator();
		while(iterator.hasNext()) {
			Orderitem oi = (Orderitem)iterator.next();
			Product p = oi.getProduct();
			int n = oi.getNumber();
			totalprice += p.getPrice()*n;
		}
		return totalprice;
	}
	
	/*@SuppressWarnings("rawtypes")
	public String toString(){
		String str = "{cart:[";
		Set sc = cart.entrySet();
		Iterator iterator = (Iterator) sc.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			int id = (Integer) me.getKey();
			OrderItem oitem = (OrderItem) me.getValue();
			str+="{"+id+":["+oitem.toString()+"]}";
		}
		return str+"]}";
	}*/
	
	public Map<Integer, Orderitem> getCart() {
		return cart;
	}

	public void setCart(Map<Integer, Orderitem> cart) {
		this.cart = cart;
	}

}
