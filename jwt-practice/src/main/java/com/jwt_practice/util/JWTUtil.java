package com.jwt_practice.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	private final String SECRET_KEY = "qazwsxedcrfvtgbyhnujmikolpmnbvcxzlkjhgfdsapoiuytrewq";

	public SecretKey getKey() {

		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	public String CreateToken(String username) {
		return Jwts.builder().subject(username).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2)).signWith(getKey()).compact();

	}

	public String getUsername(String token) {
		return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getExpiration().after(new Date());
		
	}
	public boolean isValidToken(String user,String token) {
		String username = getUsername(token);
		return user.equals(username) && isTokenExpired(token);
		
	}
}
