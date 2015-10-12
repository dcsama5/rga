package com.main.dao;

import java.util.List;

import com.main.entities.Customer;

public interface DAO {
	
	public void addCustomer(Customer customer);
	public void deleteCustomer(String id);
	public Customer findCustomer(String id);
	public void updateCustomer(Customer customer);
	public boolean checkContains(Customer customer);
	public List<Customer> findAllCustomers();
}
