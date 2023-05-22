package com.example.motorServicing.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.motorServicing.dto.LoginDto;
import com.example.motorServicing.dto.UserDto;
import com.example.motorServicing.entity.Admin;
import com.example.motorServicing.entity.User;
import com.example.motorServicing.repository.AdminRepository;
import com.example.motorServicing.repository.UserRepository;
import com.example.motorServicing.response.LoginMesage;
import com.example.motorServicing.service.UserService;

@Service
public class UserImpl implements UserService{
	

    @Autowired
    private UserRepository userRepository;
    


    @Autowired
    private PasswordEncoder passwordEncoder;

//    String adminUsername="admin@gmail.com";
//    String adminPassword = this.passwordEncoder.encode("admin@123");
    
    
	@Override
	public String addUser(UserDto userDto) {

			String name = userDto.getName();
			String email = userDto.getEmail();
			String password = 	this.passwordEncoder.encode(userDto.getPassword());
		
		User user = new User(name,email,password,"user");
		userRepository.save(user);
		return user.getName();
   }

	
	    @Override
	    public LoginMesage loginUser(LoginDto loginDto) {
	    	
//	    	if (loginDto.getEmail().equals("admin@gmail.com") ) {
//	    		if(loginDto.getPassword().equals("admin@123")) {
//	    			return new LoginMesage("Login Success", true,"admin");
//	    		}	
//	    	}
	    	
	    	
	        User user1 = userRepository.findByEmail(loginDto.getEmail());
	        if (user1 != null) {
	            String password = loginDto.getPassword();
	            String encodedPassword = user1.getPassword();
	            String role = user1.getUserRole();
	            
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<User> user= userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
	                if (user.isPresent()) {
	                    return new LoginMesage("Login Success", true,role);
	                } else {
	                    return new LoginMesage("Login Failed", false,"");
	                }
	            } else {

	                return new LoginMesage("password Not Match", false,"");
	            }
	        }else {
	            return new LoginMesage("Email not exits", false,"");
	        }
	    }
}
