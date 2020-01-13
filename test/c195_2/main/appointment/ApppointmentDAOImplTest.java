package c195_2.main.appointment;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import c195_2.main.database.DBUtil;

public class ApppointmentDAOImplTest {
	
	AppointmentDAO dao;

	@Before
	public void beforeEach() {
		dao = new AppointmentDAOImpl();
	}

	@AfterClass
	public static void AfterClass() {
		DBUtil.closeConnection();
	}

	@Test
	public void test() {
		Appointment a = new Appointment();
		a.title = "The Title";
		a.customerId = 4;
		a.description = "descrip";
		a.location = "The place";
		a.contact = "The secret";
		a.type = "Who fuking knows";
		
		a.url = "https://google.com";
		a.userId = 1;
		a.startTime = new Date(System.currentTimeMillis());
		a.endTime = new Date(System.currentTimeMillis());
		dao.addOrUpdate(a);
		assertTrue(a.appointmentId > 0);
	}
}
