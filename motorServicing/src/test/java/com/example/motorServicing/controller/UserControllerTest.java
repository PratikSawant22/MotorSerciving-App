package com.example.motorServicing.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.motorServicing.dto.LoginDto;
import com.example.motorServicing.dto.UserDto;
import com.example.motorServicing.entity.Order;
import com.example.motorServicing.entity.Product;
import com.example.motorServicing.entity.User;
import com.example.motorServicing.repository.OrderRepository;
import com.example.motorServicing.repository.ProductRepository;
import com.example.motorServicing.repository.UserRepository;
import com.example.motorServicing.service.UserService;

@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;
	@Mock
	UserRepository userRepository;

	@Mock
	ProductRepository productRepository;

	@Mock
	OrderRepository orderRepository;


	@Test
	public void saveUserTest() {
		UserDto userDto = new UserDto("pratik", "pratik@test.com", "password");
		userController.saveUser(userDto);
	}
	@Test
	public void LoginUserTest() {
		LoginDto LoginDto = new LoginDto("usenaeme", "password");
		userController.LoginUser(LoginDto);
	}
	@Test
	public void listProductsTest() {
		userController.listProducts();
	}
	@Test
	public void saveOrderTest() {
		Order o1 = new Order("user1", "101", "12-12-2021", "12:30", "Pune", 123);
		userController.saveOrder(o1);
	}

	
	
//	@Test
//	public void saveUserTest() {
//		UserDto userDto = new UserDto("pratik", "pratik@test.com", "password");
//		User user1 = new User("pratik", "pratik@test.com", "password");
//
//		Mockito.when(userRepository.save(user1)).thenReturn(user1);
//		assertEquals(user1.getName(), userService.addUser(userDto));
//	}

//	@Test
//	public void saveOrderTest() {
//		Order o1 = new Order("user1", "101", "12-12-2021", "12:30", "Pune", 123);
//		Order o2 = new Order("user2", "103", "04-03-2023", "15:00", "Kharadi", 121);
//		List<Order> orderList = new ArrayList<Order>();
//		orderList.add(o1);
//		orderList.add(o2);
//
//		Mockito.when(orderRepository.findAll()).thenReturn(orderList);
//		List<Order> ord = orderRepository.findAll();
//		assertEquals(2, ord.size());
//	}

	
//	@Test
//	public void listProductsTest() {
//
//		Product p1 = new Product(111L, "product1", "safdasdf", 1000.00f, "url");
//		Product p2 = new Product(121L, "product2", "safsdsfdsdfdasdf", 2000.00f, "url2");
//		List<Product> productList = new ArrayList<Product>();
//
//		productList.add(p1);
//		productList.add(p2);
//		Mockito.when(productRepository.findAll()).thenReturn(productList);
//
//		List<Product> prodList = productRepository.findAll();
//
//		assertEquals(2, prodList.size());
//	}	

}
