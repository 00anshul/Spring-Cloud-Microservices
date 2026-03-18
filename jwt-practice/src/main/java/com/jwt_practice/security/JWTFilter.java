package com.jwt_practice.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt_practice.service.AuthenticationService;
import com.jwt_practice.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	JWTUtil util;

	@Autowired
	AuthenticationService authservice;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String token = request.getHeader("Authrisation");
		String emailid = null;

		if (token != null && !token.isEmpty() && !token.isBlank()) {
			emailid = util.getUsername(token);
			System.out.println("Request came for token is invalid" + emailid);

		} else {
			System.out.println("Once per request token is invalid" + token);
		}

		if (emailid != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userdetails = authservice.loadUserByUsername(emailid);

			boolean validtoken = util.isValidToken(userdetails.getUsername(), token);
			System.out.println("Result of valid token" + validtoken);
			if (validtoken) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userdetails, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} else {
				System.out.println("Invalid Token : " + emailid);
			}
		}
		filterChain.doFilter(request, response);
	}

}
