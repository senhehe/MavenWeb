package com.sen.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Double totalprice;
	private Timestamp orderdate;
	private String linkman;
	private String address;
	private String phone;
	private Integer status;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(User user, Double totalprice, Timestamp orderdate,
			String linkman, String address, String phone, Integer status) {
		this.user = user;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
		this.linkman = linkman;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}

	/** full constructor */
	public Order(User user, Double totalprice, Timestamp orderdate,
			String linkman, String address, String phone, Integer status,
			Set orderitems) {
		this.user = user;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
		this.linkman = linkman;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}