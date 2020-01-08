package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import c195_2.main.database.DBUtil;

public class CustomerDAOImplTest {

	
	CustomerDAO dao;
	
	@Before
	public void beforeEach() {
		dao = new CustomerDAOImpl();
	}
	
	@AfterClass
	public static void AfterClass(){
		DBUtil.closeConnection();
	}
	
	@Test
	public void test() {
		Customer c = new Customer();
		c.setCustomerName("Brooke");
		c.active = true;
		c.addressId = 1;
		dao.addOrUpdate(c);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testFind() {
		Customer c = dao.find(1);
		assertNotNull(c.customerName);

	}

}
