package unittest.entity;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.main.Application;
import com.main.dao.DAO;
import com.main.entities.Customer;
import com.main.security.DomainUsernamePasswordAuthenticationToken;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest
public class TestCustomer {

	@Autowired
	private DAO customerDAO;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * This method tests if it is able to persist
	 * an customer object in the database.
	 */
	
	@BeforeClass
	public static void sdasd() {
		DomainUsernamePasswordAuthenticationToken token = new DomainUsernamePasswordAuthenticationToken("ameer", "ameer_password");
		SecurityContextHolder.getContext().setAuthentication(token);
		System.out.println("gets called");
	}
	
	@Test
	@Ignore
	public void customerCreate() {
		Customer customer = new Customer();
		customer.setUsername("ibrahim");
		customer.setPassword("ibrahim_password");
		customer.setEmail("ibrahim200500@gmail.com");
		customerDAO.addCustomer(customer);
	}
	
	/**
	 * This method tests a duplicate entry and is expected to throw
	 * Springs DataIntegrityViolationException
	 */
	@Test(expected = DataIntegrityViolationException.class)
	@Ignore
	public void duplicateEntry() {
		Customer customer = new Customer();
		customer.setUsername("ameer");
		customer.setPassword("ameer_password");
		customer.setEmail("dcs.ama5@gmail.com");
		customerDAO.addCustomer(customer);
		
	}
	
	/**
	 * This method checks for an entity not located in the database
	 * and trys to delete it.
	 */
	@Test(expected = ObjectRetrievalFailureException.class)
	@Ignore
	public void deleteFakeEntry() {
		customerDAO.deleteCustomer("steve");
	}
	
	/**
	 * Deletes existing entity
	 */
	@Test
	@Transactional
	@Ignore
	public void deleteEnttry() {
		customerDAO.deleteCustomer("ameer");
	}
	
	@Test
	@Ignore
	public void findCustomer() {
		Customer customer = (Customer) customerDAO.findCustomer("ameer");
	}
	
	@Test
	public void findAll() {
		List<Customer> customers = customerDAO.findAllCustomers();
		for(int i=0; i<customers.size(); i++)
			System.out.println(customers.get(i).getUsername());
	}
	
	@Test
	@Ignore
	public void updateCustomer() {
		Customer customer = customerDAO.findCustomer("ameer");
		System.out.println("email address before:"+customer.getEmail());
		customer = new Customer();
		customer.setUsername("ameer");
		customer.setEmail("xxx@gmail.com");
		customerDAO.updateCustomer(customer);
		customer = customerDAO.findCustomer("ameer");
		assertEquals("xxx@gmail.com", customer.getEmail());
	}
}
