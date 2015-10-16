package com.main.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.main.entities.Customer;

public class DomainUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {


	public DomainUsernamePasswordAuthenticationToken(String username, String credentials) {
		super(username, credentials);
	}
	
	public DomainUsernamePasswordAuthenticationToken(Customer principal, String credentials) {
		super(principal, credentials);
	}
	
	public DomainUsernamePasswordAuthenticationToken(Customer principal, String credentials, Collection authorities) {
		super(principal, credentials, authorities);
	}
	
}
