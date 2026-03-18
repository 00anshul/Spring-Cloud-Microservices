package com.jwt_practice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt_practice.dto.UserDTO;
import com.jwt_practice.entity.UserInfo;
import com.jwt_practice.repository.UserRepository;

@Service
public class UserService {


	UserRepository userjpa;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public UserService(UserRepository userjpa) {
		this.userjpa = userjpa;
	}

	public UserInfo createUser(UserDTO dto) {
		UserInfo info = new UserInfo();

		info.setEmailid(dto.getEmailid());
		info.setName(dto.getName());
		info.setPhone(dto.getPhone());
		info.setPswd(encoder.encode(dto.getPswd()) );
		
		return userjpa.save(info);
	}
	
}
