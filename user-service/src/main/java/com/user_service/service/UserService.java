package com.user_service.service;

import org.springframework.stereotype.Service;
import com.user_service.entity.UserInformation;
import com.user_service.repository.UserRepo;

@Service
public class UserService {
	private UserRepo jpa;

	public UserService(UserRepo jpa) {
		super();
		this.jpa = jpa;
	}

	public String createUser(UserInformation info) {
		jpa.save(info);
		return "User created successfully with ID: " + info.getId();
	}

	public UserInformation findByEmail(String email) {

		return jpa.findByEmail(email);
	}

}
