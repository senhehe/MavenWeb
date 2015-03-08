package com.sen.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private String sex;
	private Timestamp birthday;
	private String email;
	private Integer type;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String sex,
			Timestamp birthday, String email, Integer type) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.type = type;
	}

	/** full constructor */
	public User(String username, String password, String sex,
			Timestamp birthday, String email, Integer type, Set orders) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.type = type;
		this.orders = orders;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}