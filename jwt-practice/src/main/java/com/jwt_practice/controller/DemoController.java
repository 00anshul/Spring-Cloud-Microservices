package com.jwt_practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt_practice.dto.LoginDTO;
import com.jwt_practice.dto.UserDTO;
import com.jwt_practice.entity.UserInfo;
import com.jwt_practice.service.UserService;
import com.jwt_practice.util.JWTUtil;

@RestController
public class DemoController {

	@Autowired
	JWTUtil util ;
	@Autowired
	private UserService service;
	@Autowired
	private AuthenticationManager authentication;
	
	@GetMapping("/{username}")
	public String demo(@PathVariable String username) {
		return util.CreateToken(username);
	}
	
	@GetMapping("/get-user/{token}")
	public String getname(@PathVariable String token) {
		return util.getUsername(token);
	}
	
	@GetMapping("/check/{token}/{user}")
	public boolean checktoken(@PathVariable String token,@PathVariable String user) {
		return util.isValidToken(token,user);
	}
	
	@PostMapping("/public/create")
	public UserInfo createuser(@RequestBody UserDTO dto) {
		return service.createUser(dto);
	}
	
	@PostMapping("/public/user/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
	    UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(dto.getEmailid(), dto.getPswd());
	    Authentication auth = authentication.authenticate(credentials);
	    
	    String token = util.CreateToken(dto.getEmailid());

	    HttpHeaders responseHeader = new HttpHeaders();
	    responseHeader.add("Autherisation", token);

	    //Message in body, token only in header
	    return new ResponseEntity<String>("Welcome home : " + dto.getEmailid(), responseHeader, HttpStatus.ACCEPTED);
	}
}
