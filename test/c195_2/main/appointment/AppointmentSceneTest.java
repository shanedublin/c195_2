package c195_2.main.appointment;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class AppointmentSceneTest {

	


	
	@Test
	public void test() throws ParseException {
		AppointmentScene.dateFormat.parse("2020-1-1-01:20-AM");
	}


}
