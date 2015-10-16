package com.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomerAuthenticationProvider customerAuthenticationProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/resources");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilter(domainUsernamePasswordAuthenticationFilterBean());
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
		.and().addFilter(domainUsernamePasswordAuthenticationFilterBean())
		.formLogin()
			.loginPage("/").permitAll()
			.successHandler(successHandler())
			.and()
			.logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customerAuthenticationProvider);
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		LoginSuccessHandler handler = new LoginSuccessHandler();
		return handler;
	}
	
	@Bean(name="authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Bean
	public DomainUsernamePasswordAuthenticationFilter domainUsernamePasswordAuthenticationFilterBean() throws Exception{
		DomainUsernamePasswordAuthenticationFilter filter = new DomainUsernamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/", "POST"));
		filter.setAuthenticationSuccessHandler(successHandler());
		return filter;
	}
	
	
}
