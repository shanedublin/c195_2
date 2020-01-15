package c195_2.main.appointment;


import java.sql.Date;
import java.sql.Timestamp;

import c195_2.main.Entity;


public class Appointment extends Entity {
	
	public Integer appointmentId;
	public Integer userId = -1;
	public Integer customerId  = -1;
	public String title;
	public String description;
	public String location;
	public String contact;
	public String type;
	public String url;
	
	public Timestamp startTime;
	public Timestamp endTime;

}
