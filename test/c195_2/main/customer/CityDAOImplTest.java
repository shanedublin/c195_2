package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CityDAOImplTest {
	

	CityDAO dao;
	
	@Before
	public void beforeEach() {
		dao = new CityDAOImpl();
	}
	

	@Test
	public void test() {
		City c = new City();
		c.city = "Huston";
		c.countryId = 1;
		dao.addOrUpdate(c);
	}

}
