package com.sen.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String info;
     private Double price;
     private String picture;
     private Set orderitems = new HashSet(0);


    // Constructors

    /** default constructor */
    public Product() {
    }

	/** minimal constructor */
    public Product(String name, Double price, String picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }
    
    /** full constructor */
    public Product(String name, String info, Double price, String picture, Set orderitems) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.picture = picture;
        this.orderitems = orderitems;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    @JSON(serialize=false) 
    public Set getOrderitems() {
        return this.orderitems;
    }
    
    public void setOrderitems(Set orderitems) {
        this.orderitems = orderitems;
    }
   








}