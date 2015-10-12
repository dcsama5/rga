package com.main.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.main.entities.Customer;

public class DomainUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

	public DomainUsernamePasswordAuthenticationToken(Customer principal, String credentials) {
		super(principal, credentials);
		// TODO Auto-generated constructor stub
	}

}
