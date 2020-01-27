package c195_2.main.appointment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import c195_2.main.Entity;

public class Appointment extends Entity {

	public Integer appointmentId;
	public Integer userId = -1;
	public Integer customerId = -1;
	public String title;
	public String description;
	public String location;
	public String contact;
	public String type;
	public String url;

	public Timestamp startTime;
	public Timestamp endTime;

	public Appointment() {
	}

	public Appointment(ResultSet rs) throws SQLException {

		this.appointmentId = rs.getInt("appointmentId");
		this.title = rs.getString("title");
		this.customerId = rs.getInt("customerId");
		this.userId = rs.getInt("userId");
		this.description = rs.getString("description");
		this.location = rs.getString("location");
		this.contact = rs.getString("contact");
		this.type = rs.getString("type");
		this.url = rs.getString("url");
		this.startTime = rs.getTimestamp("start");
		System.out.println(rs.getTimestamp("start"));
		this.endTime = rs.getTimestamp("end");
	}

}
