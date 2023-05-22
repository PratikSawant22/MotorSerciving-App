package com.example.motorServicing.service;

import com.example.motorServicing.dto.LoginDto;
import com.example.motorServicing.dto.UserDto;
import com.example.motorServicing.response.LoginMesage;


public interface UserService {
	
	  String addUser(UserDto userDto);
	  LoginMesage loginUser(LoginDto loginDto);
}
	