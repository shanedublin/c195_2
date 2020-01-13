package c195_2.main.login;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import c195_2.main.database.DBUtil;

public class UserDAOImplTest {

	UserDAO dao;
	@Before
	public void beforeEach() {
		dao = new UserDAOImpl();
	}
	
	@AfterClass
	public static void after() {
		DBUtil.closeConnection();
	}
	
	@Test
	public void test() {
		List<User> users = dao.getUsers();
		assertTrue(users.size() > 0);
	}

}
