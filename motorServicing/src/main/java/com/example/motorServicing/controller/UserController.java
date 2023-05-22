package com.example.motorServicing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.motorServicing.dto.LoginDto;
import com.example.motorServicing.dto.UserDto;
import com.example.motorServicing.entity.Order;
import com.example.motorServicing.entity.Product;
import com.example.motorServicing.entity.UserInfo;
import com.example.motorServicing.repository.OrderRepository;
import com.example.motorServicing.repository.ProductRepository;
import com.example.motorServicing.repository.UserInfoRepository;
import com.example.motorServicing.response.LoginMesage;
import com.example.motorServicing.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@PostMapping("/save")
	public String saveUser(@RequestBody UserDto userDto) {
		String id = userService.addUser(userDto);
		return id;
	}

	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody LoginDto loginDto) {
		LoginMesage loginMesage = userService.loginUser(loginDto);
		return ResponseEntity.ok(loginMesage);
	}

	@GetMapping("/users")
	public List<UserInfo> getAllUsers() {
		return userInfoRepository.findAll();
	}

	@GetMapping("/product")
	public List<Product> listProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@PostMapping("/product")
	public String saveProduct(@RequestBody Product product) {
		System.out.println(product);
		productRepository.save(product);
		return "Product Added.";
	}

	@PostMapping("/order")
	public String saveOrder(@RequestBody Order order) {
		System.out.println(order);
		orderRepository.save(order);
		System.out.println("ACCEPT ORDER");
		return "";
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable long id) {
		productRepository.deleteProduct(id);
		String response = "product with id " + id + " is Deleted";
		return response;
	}

	@GetMapping("/users/{user}")
	public UserInfo getUserDetails(@PathVariable String user) {
		return userInfoRepository.findByEmail(user);
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/orders/{user}")
	public List<Order> getUserOrders(@PathVariable String user) {
		return orderRepository.findByUser(user);
	}

	@DeleteMapping("/orders/{id}")
	public String getUserOrders(@PathVariable long id) {
		orderRepository.deleteById(id);
		String response = "Order with id " + id + " is Deleted";
		return response;
	}

	@PutMapping("/orders/{id}")
	public String updateOrder(@PathVariable long id, @RequestBody Order order) {
		orderRepository.updateOrderStatus(order.getStatus(), id);
		return "order updated";
	}

	@PostMapping("/userinfo")
	public String saveOrder(@RequestBody UserInfo userInfo) {

		System.out.println(userInfo);
		UserInfo user = userInfoRepository.findByEmail(userInfo.getEmail());
		if (user == null) {
			userInfoRepository.save(userInfo);
		} else {
			user.setFullname(userInfo.getFullname());
			user.setPhone(userInfo.getPhone());
			user.setMobile(userInfo.getMobile());
			user.setAddress(userInfo.getAddress());
			userInfoRepository.save(user);
		}
		return "Profile Updated";
	}

	@GetMapping("/")
	public String home() {
		return "working";
	}

//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return (List<User>) userRepository.findAll();
//    }
//
//    @PostMapping("/users")
//    void addUser(@RequestBody User user) {
//        userRepository.save(user);
//    }

//    @PostMapping("/users")
//    void addUser(@RequestBody User user) {
//        userRepository.save(user);
//    }
}
