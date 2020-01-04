package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerDAOImplTest {

	
	CustomerDAOImpl impl;
	
	@Before
	public void beforeEach() {
		impl = new CustomerDAOImpl();
	}
	
	@Test
	public void test() {
		Customer c = new Customer();
		c.customerName = "Brooke";
		impl.add(c);
		//fail("Not yet implemented");
	}

}
