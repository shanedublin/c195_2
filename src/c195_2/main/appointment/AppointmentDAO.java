package c195_2.main.appointment;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface AppointmentDAO {
	
	

	public Appointment addOrUpdate(Appointment a);
	public Appointment find(Appointment a);
	public List<Appointment> findByUserAndDay(Integer userId, Date date);
	public boolean delete(Integer a);
	public boolean appoinmentOverlaps(Appointment a);
	public Appointment in15Mins(Integer userId);
	public List<AppointmentReport> getAppoinmentReport() throws SQLException;
	public List<Appointment> getAllAppointments();

}
