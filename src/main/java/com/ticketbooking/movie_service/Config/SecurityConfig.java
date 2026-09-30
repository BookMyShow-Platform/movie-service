package com.ticketbooking.movie_service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		return http.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.oauth2ResourceServer(oauth2->oauth2.jwt(jwt->{}))
				.authorizeHttpRequests(request->request.anyRequest().authenticated())
				.build();
	}
}
