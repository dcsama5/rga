package com.main.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.main.entities.Customer;

public final class CustomerUserDetails extends Customer implements UserDetails {
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public CustomerUserDetails(Customer customer) {
		setUsername(customer.getUsername());
		setPassword(customer.getPassword());
		setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
