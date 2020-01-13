package c195_2.main.appointment;


import java.sql.Date;

import c195_2.main.Entity;


public class Appointment extends Entity {
	
	public Integer appointmentId;
	public Integer userId;
	public Integer customerId;
	public String title;
	public String description;
	public String location;
	public String contact;
	public String type;
	public String url;
	
	public Date startTime;
	public Date endTime;

}
