package c195_2.main.appointment;

public class AppointmentReport {

	public String type = "";
	public Integer number = 0;

	@Override
	public String toString() {
		return "No. meetings: "+number+ "  Type: " + type;
	}

}
