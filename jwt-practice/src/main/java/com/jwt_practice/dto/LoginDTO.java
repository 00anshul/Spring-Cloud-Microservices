package com.jwt_practice.dto;

public class LoginDTO {

	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	private String emailid;
	private String pswd;
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
	
}
