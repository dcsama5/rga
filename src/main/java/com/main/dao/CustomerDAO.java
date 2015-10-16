package com.main.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.entities.Customer;

@Repository
public class CustomerDAO implements DAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	//@Secured("ROLE_AMEER")
	public void addCustomer(Customer customer) {
		currentSession().save(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(String id) {
		Customer ent = (Customer) currentSession().load(Customer.class, id);
		currentSession().delete(ent);
	}
	
	@Override
	@Transactional
	@Secured("ROLE_USER")
	public List<Customer> findAllCustomers() {
		Query query = currentSession().getNamedQuery("customer.findAll");
		List<Customer> customers = query.list();
		return customers;
	}
	@Override
	@Transactional
	public Customer findCustomer(String id) {
		Customer loadedCustomer = (Customer) currentSession().get(Customer.class, id);
		return loadedCustomer;
	}

	@Override
	@Transactional
	//@Secured("ROLE_AMEER")
	public void updateCustomer(Customer customer) {
		currentSession().update(customer);
	}
	
	@Transactional
	@Override
	public boolean checkContains(Customer customer) {
		return currentSession().contains(customer);
	}
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

}
