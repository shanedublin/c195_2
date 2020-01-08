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
		Address addr = new Address();
		addr.address = "1509 W ILESO Cir";
		addr.address2 = "Apt 209";
		addr.phone = "210-557-5100";
		addr.postalCode = "85252";
		addr.cityId = 1;
		dao.addOrUpdate(addr);
		assertTrue(addr.addressId > 5);
	}
	
	@Test
	public void testUpdate() {
		Address addr = new Address();
		addr.address = "1509 W ILESO Cir";
		addr.address2 = "Apt 222";
		addr.phone = "210-557-5100";
		addr.postalCode = "85252";
		addr.cityId = 1;
		addr.addressId = 2;
		dao.addOrUpdate(addr);
		assertTrue(addr.addressId == 2);
	}

}
