package com.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.entity.UserInformation;
import com.user_service.service.UserService;

@RestController
public class UserController {
	private UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public String createUser(@RequestBody UserInformation info) {
		return service.createUser(info);
	}

	@GetMapping("/find-by-email")
	public UserInformation getUserByEmail(@PathVariable String email) {
		return service.findByEmail(email); 
	}
	@GetMapping("/info")
	public String details() {
		System.out.println("hii");
		return "hi"; 
	}
}
