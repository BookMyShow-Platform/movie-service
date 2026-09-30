package com.ticketbooking.movie_service.Config;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
@Configuration
public class JwtKeyConfig {
	 @Bean
	    public RSAPublicKey rsaPublicKey() throws Exception {

	        ClassPathResource resource =
	                new ClassPathResource("keys/public.pem");

	        try (InputStream inputStream = resource.getInputStream()) {

	            String key = new String(inputStream.readAllBytes());

	            key = key
	                    .replace("-----BEGIN PUBLIC KEY-----", "")
	                    .replace("-----END PUBLIC KEY-----", "")
	                    .replaceAll("\\s+", "");

	            byte[] decoded = Base64.getDecoder().decode(key);

	            X509EncodedKeySpec keySpec =
	                    new X509EncodedKeySpec(decoded);

	            KeyFactory keyFactory =
	                    KeyFactory.getInstance("RSA");

	            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
	        }
	    }

}
