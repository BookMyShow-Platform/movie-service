package com.ticketbooking.movie_service.Config;

import java.security.interfaces.RSAPublicKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
@Configuration
public class JwtConfig {
	@Bean
	public JwtDecoder jwtDecoder(RSAPublicKey publicKey) {
		return NimbusJwtDecoder
                .withPublicKey(publicKey)
                .build();
		
	}

}
