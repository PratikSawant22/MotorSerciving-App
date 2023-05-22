package com.example.motorServicing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
		
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String user;
    private String product_id;
    private String date ;
    private String time;
    private String address;
    private int price;
    private String status;
    
    public Order() {
    	
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order(String user, String product_id, String date, String time, String address, int price, String status) {
		super();
		this.user = user;
		this.product_id = product_id;
		this.date = date;
		this.time = time;
		this.address = address;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", product_id=" + product_id + ", date=" + date + ", time=" + time
				+ ", address=" + address + ", price=" + price + ", status=" + status + "]";
	}

}	
