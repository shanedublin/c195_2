package c195_2.main.appointment;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;

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
		a.description = "the Best description";
		a.location = "The place";
		a.contact = "The secret";
		a.type = "FBI";
		
		a.url = "https://google.com";
		a.userId = 1;
		a.startTime = new Timestamp(System.currentTimeMillis());
		a.endTime = new Timestamp(System.currentTimeMillis() + 10000);
		dao.addOrUpdate(a);
		assertTrue(a.appointmentId > 0);
	}
	
	
	@Test
	public void testOverlap() {
		Appointment a = new Appointment();
		a.userId  = 1;
		a.customerId = 4;
		a.startTime = new Timestamp(System.currentTimeMillis() + 50);
		a.startTime = new Timestamp(System.currentTimeMillis() + 50);
		boolean appoinmentOverlaps = dao.appoinmentOverlaps(a);
		
		assertTrue(appoinmentOverlaps);
	}
}
