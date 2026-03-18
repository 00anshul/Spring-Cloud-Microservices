package com.jwt_practice.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

	@Autowired
	JWTFilter jwtfilter;

	@Bean
	AuthenticationManager  getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception {
		
		System.out.println("Authentication Manager intialized");
		return  configuration.getAuthenticationManager();
		
		
	}

    @Bean
    SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		return http.csrf(csrf->csrf.disable())
		.cors(cors->cors.disable())
		.authorizeHttpRequests(reqs->reqs.requestMatchers("/public/create","/public/user/login").permitAll()
				.anyRequest().authenticated())
		.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class).build();
	}

    @Bean
    BCryptPasswordEncoder encode() {
    	return new BCryptPasswordEncoder();
    }
	
}
