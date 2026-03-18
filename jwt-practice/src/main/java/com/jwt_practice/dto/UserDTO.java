package com.jwt_practice.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDTO {

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	private String emailid;
	private String pswd;
	private String phone;
	private String name;

	public UserDTO(String emailid, String pswd, String phone, String name) {
		super();
		this.emailid = emailid;
		this.pswd = pswd;
		this.phone = phone;
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
