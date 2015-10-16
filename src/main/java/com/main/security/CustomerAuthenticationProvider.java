package com.main.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.main.dao.DAO;
import com.main.entities.Customer;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {

	private DAO customerDAO;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public CustomerAuthenticationProvider(DAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("authenticated before"+authentication.isAuthenticated());
		DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
		System.out.println("authenticated:"+token.isAuthenticated());
		
		String username = token.getName();
		
		CustomerUserDetails customer = (CustomerUserDetails) userDetailsService.loadUserByUsername(username);
		System.out.println(username + customer.getPassword() + token.isAuthenticated() + token.getCredentials());
		String password = customer.getPassword();
		if(!password.equals(token.getCredentials()))
			throw new BadCredentialsException("Invalid username / password");
		
		return new DomainUsernamePasswordAuthenticationToken(customer, password, customer.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return DomainUsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
