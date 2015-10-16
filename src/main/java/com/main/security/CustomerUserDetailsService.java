package com.main.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.main.dao.DAO;
import com.main.entities.Customer;

@Component
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired 
	private DAO customerDAO; 
	
	@Override
	public CustomerUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerDAO.findCustomer(username);
		if(customer==null)
			throw new UsernameNotFoundException("Invalid Username/Password");
		return new CustomerUserDetails(customer);
	}

/*	private final class CustomerUserDetails extends Customer implements UserDetails {
		
		private Collection<? extends GrantedAuthority> authorities;
		
		public CustomerUserDetails(Customer customer) {
			setUsername(customer.getUsername());
			setPassword(customer.getPassword());
			setAuthorities(AuthorityUtils.createAuthorityList("ROLE_AMEER"));
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
		
		
	}*/
}
