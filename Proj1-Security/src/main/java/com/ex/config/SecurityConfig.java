package com.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private MyUserDetailsService service;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();		
//	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user = User.builder().username("Raj").password(passwordEncoder().encode("123")).roles("USER").build();
//		UserDetails admin = User.builder().username("Raja").password(passwordEncoder().encode("12345")).roles("ADMIN").build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//		
//	}

	
	public UserDetailsService userDetailsService() {
		return service;	
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;		
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity sec) throws Exception {
		
		return sec.csrf(csrf->csrf.disable())    
				.authorizeHttpRequests(auth-> auth.requestMatchers("/home","/register/**").permitAll()
												.requestMatchers("/re/admin/**").hasRole("ADMIN")
												.requestMatchers("/re/user/**").hasAnyRole("USER","ADMIN")
												.requestMatchers("/login").permitAll()
												.requestMatchers("/images/**", "/css/**", "/js/**", "/WEB-INF/views/**").permitAll()
												.anyRequest().authenticated())			
							.formLogin(form -> form
									    .permitAll())				
				.build();
		
	}
}
