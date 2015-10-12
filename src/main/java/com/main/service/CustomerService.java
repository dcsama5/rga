package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.DAO;

@Service
public class CustomerService {
	
	@Autowired
	private DAO customerDAO;
	
}
