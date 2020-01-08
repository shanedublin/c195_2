package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerDAOImplTest {

	
	CustomerDAO dao;
	
	@Before
	public void beforeEach() {
		dao = new CustomerDAOImpl();
	}
	
	@Test
	public void test() {
		Customer c = new Customer();
		c.customerName = "Brooke";
		c.active = true;
		c.addressId = 1;
		dao.add(c);
		//fail("Not yet implemented");
	}

}
