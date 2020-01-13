package c195_2.main.appointment;

import java.sql.Date;
import java.util.List;

public interface AppointmentDAO {
	
	

	public Appointment addOrUpdate(Appointment a);
	public Appointment find(Appointment a);
	public List<Appointment> findByUserAndDay(Integer userId, Date date);
	public boolean delete(Integer a);

}
