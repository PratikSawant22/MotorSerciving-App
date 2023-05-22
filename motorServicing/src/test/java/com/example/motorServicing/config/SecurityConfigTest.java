package com.example.motorServicing.config;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class SecurityConfigTest {
	
	SecurityConfig securityConfig = new SecurityConfig();
	
	
	@Test
	public void passwordEncoder() {
		securityConfig.passwordEncoder();
	}
	
	
}
