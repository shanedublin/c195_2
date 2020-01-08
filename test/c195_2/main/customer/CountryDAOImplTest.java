package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import c195_2.main.database.DBUtil;

public class CountryDAOImplTest {

	
	CountryDAO dao;
	
	@Before
	public void beforeEach() {
		dao = new CountryDAOImpl();
	}
	
	@AfterClass
	public static void AfterClass(){
		DBUtil.closeConnection();
	}
	
	@Test
	public void test() {
		Country c = new Country();
		c.country = "United States";
		dao.addOrUpdate(c);
	}
	
	@Test
	public void testQuery() {
		Country c = new Country();
		c.country = "United States";
		Country find = dao.find(c);
		assertNotNull(find.countryId);
	}
	
	@Test
	public void testFindNull() {
		Country c = new Country();
		c.country = "blah blah";
		Country find = dao.find(c);
		assertNull(find.country);
	}

}
