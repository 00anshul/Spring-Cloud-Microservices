package com.jwt_practice.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt_practice.entity.UserInfo;
import com.jwt_practice.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	
	private UserRepository userjpa;



	public AuthenticationService(UserRepository userjpa) {
		super();
		this.userjpa = userjpa;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional <UserInfo>  info = userjpa.findById(email);
		
		if(info.isPresent()) {
			System.out.println("User Authentication Service : "+email);
			return info.get();
		}
		else {
			throw new UsernameNotFoundException("Username with "+email+" not found");
		}
	}

}
