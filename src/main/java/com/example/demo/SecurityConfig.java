//package com.example.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//public class SecurityConfig {
//	
//	@Bean
//	public WebSecurityCustomizer websecurityCustomizer() {
//		return (web) -> web.ignoring()
//				.requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
//	}
//	
//}
