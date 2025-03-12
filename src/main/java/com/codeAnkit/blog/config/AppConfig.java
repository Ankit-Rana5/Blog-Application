package com.codeAnkit.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codeAnkit.blog.security.CustomUserDetailService;

@Configuration
public class AppConfig {
	
	@Autowired
	private CustomUserDetailService ustomUserDetailService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {

		return builder.getAuthenticationManager();
	}
	
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.ustomUserDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}

}
