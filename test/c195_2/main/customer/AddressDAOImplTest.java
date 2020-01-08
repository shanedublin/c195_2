package c195_2.main.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressDAOImplTest {

	AddressDAO dao;
	
	@Before
	public void beforeEach() {
		dao = new AddressDAOImpl();
	}
	

	@Test
	public void test() {
		Address c = new Address();
		c.address = "1509 W ILESO Cir";
		c.address2 = "Apt 209";
		c.phone = "210-557-5100";
		c.postalCode = "85252";
		c.cityId = 1;
		dao.addOrUpdate(c);
	}

}
