package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerBOTest {
	
	CustomerBO bo;
	
	@Before
	public void beforeEach() {
		bo = new CustomerBO();
	}

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setCustomerName("Testing Name");
		Address address = new Address();
		
		address.address = "1";
		address.address2 = "2";
		address.phone = "3";
		address.postalCode = "4";
		City city = new City();
		city.city = "Pheonix";
		Country country = new Country();
		country.country = "United States";
		CustomerView cv = new CustomerView();
		cv.city = city;
		cv.customer = customer;
		cv.address = address;
		cv.country = country;
		
		
		bo.saveCustomer(cv);
		System.out.println(cv.customer.customerId);
		
	}
	
	@Test
	public void testLoad() {
		CustomerView loadCustomer = bo.loadCustomer(3);
		assertNotNull(loadCustomer.address.address);
		assertNotNull(loadCustomer.city.city);
		assertNotNull(loadCustomer.country.country);
		assertNotNull(loadCustomer.customer.customerName);
		
	}

}
