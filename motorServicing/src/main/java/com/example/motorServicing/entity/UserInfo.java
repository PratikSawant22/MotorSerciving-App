package com.example.motorServicing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userInfo")
public class UserInfo {
	  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;	
    private String email;                                    
    private String fullname;
    private String phone;
    private String mobile;
    private String address;
    
    UserInfo(){
    	
    }
    
	public UserInfo(String email, String fullname, String phone, String mobile, String address) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.mobile = mobile;
		this.address = address;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", email=" + email + ", fullname=" + fullname + ", phone=" + phone
				+ ", mobile=" + mobile + ", address=" + address + "]";
	}

}
