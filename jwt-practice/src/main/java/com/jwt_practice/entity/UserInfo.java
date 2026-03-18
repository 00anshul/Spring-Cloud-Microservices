package com.jwt_practice.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInfo implements UserDetails {

	@Id
	String emailid;
	String name;
	String pswd;
	String phone;

	public UserInfo() {
		
	}

	public UserInfo(String emailid, String name, String pswd, String phone) {
		
		this.emailid = emailid;
		this.name = name;
		this.pswd = pswd;
		this.phone = phone;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pswd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmailid();
	}

}
