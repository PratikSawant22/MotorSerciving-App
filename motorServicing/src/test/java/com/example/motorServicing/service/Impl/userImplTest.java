package com.example.motorServicing.service.Impl;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.motorServicing.dto.LoginDto;
import com.example.motorServicing.dto.UserDto;
import com.example.motorServicing.entity.User;
import com.example.motorServicing.repository.UserRepository;

@SpringBootTest
public class userImplTest {

	@Mock
	PasswordEncoder passwordEncoder;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserImpl userImpl;

	String pass = "023334654";

//	@Before(value = "test")
//	public void setUp() throws Exception {
//		// Initialize mocks created above
//		MockitoAnnotations.initMocks(this);
//		// Change behaviour of `resource`
//	}

	@Test
	public void addUser() {
		UserDto userdto = new UserDto("patrik", "pratik@gmail.com", pass);
//		PasswordEncoder passwordEncoder = Mock(PasswordEncoder.class);
		ReflectionTestUtils.setField(userImpl, "passwordEncoder", passwordEncoder);
		ReflectionTestUtils.setField(userImpl, "userRepository", userRepository);
		userImpl.addUser(userdto);

	}

	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto("email ", "pass");
		User user = new User("patrik", "pratik@gmail.com", "pass");
		userImpl.loginUser(loginDto);
		Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(user);
		userImpl.loginUser(loginDto);

	}
}
