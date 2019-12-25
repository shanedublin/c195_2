package c195_2.main.appointment;

import java.util.Date;

import c195_2.main.Entity;


public class Appointment extends Entity {
	
	public int appointmentId;
	public int userId;
	public int customerId;
	public String title;
	public String description;
	public String location;
	public String contact;
	public String type;
	public String url;
	
	public Date startTime;
	public Date endTime;

}
