package com.main.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class DomainUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        // authRequest.isAuthenticated() = false since no authorities are specified
        System.out.println(username + ":"+password);
        DomainUsernamePasswordAuthenticationToken authRequest = new DomainUsernamePasswordAuthenticationToken(username, password);
        setDetails(request, authRequest);
        System.out.println("raquel");
        return this.getAuthenticationManager().authenticate(authRequest);
        
    }
    
}
