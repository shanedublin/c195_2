package c195_2.main.appointment;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class AppointmentSceneTest {

	


	
	@Test
	public void test() throws ParseException {
		AppointmentScene.dateFormat.parse("2020-1-1-01:20-AM");
	}


	
	@Test
	public void testhours() throws ParseException {
//		yyyy-M-d-h:m-a
		String startString = "2020-1-15-9:45-AM";
		String endString = "2020-1-15-3:15-PM";
		Timestamp ts =		new Timestamp(AppointmentScene.dateFormat.parse(startString).getTime());;
		Timestamp ts2 =		new Timestamp(AppointmentScene.dateFormat.parse(endString).getTime());;
		boolean inHours = AppointmentScene.buisnessTime(ts, ts2);
		assertTrue(inHours);
	}
}
