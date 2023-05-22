package com.example.motorServicing.response;


public class LoginMesage {
    String message;
    Boolean status;
    String userRole;
 

	public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public Boolean getStatus() {
        return status;
    }
 
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public LoginMesage(String message, Boolean status, String userRole) {
		super();
		this.message = message;
		this.status = status;
		this.userRole = userRole;
	}

 
//    public LoginMesage(String message, Boolean status) {
//        this.message = message;
//        this.status = status;
//    }
	
}