package com.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/").permitAll()
			.and()
			.logout().permitAll();
	}

	@Autowired 
	public void registerAuthenticationProvider(AuthenticationManagerBuilder auth, AuthenticationProvider authProvider) {
		auth.authenticationProvider(authProvider);
	}
}
