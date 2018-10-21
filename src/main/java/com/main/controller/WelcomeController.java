package com.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.dao.DAO;
import com.main.entities.Customer;

@Controller
public class WelcomeController {

	@Autowired
	private DAO customerDAO;
	
	@RequestMapping("/")
	public String welcome() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid Customer customer, BindingResult result, Model model) {
		
		try {
		customerDAO.addCustomer(customer);
		model.addAttribute("success", true);
		return "register";
		}
		catch(Exception e) 
		{
			model.addAttribute("exception", e);
			return "register";
		}
		
	}
	
	@RequestMapping(value="/home")
	public String redirectHome() {
		return "home";
	}
	
	@RequestMapping(value="/update")
	public String updateDirect() {
		return "update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void updatePOST(@RequestBody Customer customer) {
		System.out.println(customer.getUsername());
		System.out.println(customer.getPassword());
		System.out.println(customer.getEmail());
		customerDAO.updateCustomer(customer);
	}
	
	@RequestMapping(value="/list")
	public String returnList(Model model) {
		model.addAttribute("customers", customerDAO.findAllCustomers());
		return "list";
	}
}
	
