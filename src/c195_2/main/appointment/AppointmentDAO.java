package c195_2.main.appointment;

public interface AppointmentDAO {
	
	

	public Appointment addOrUpdate(Appointment a);
	public Appointment find(Appointment a);
	public boolean delete(Appointment a);

}
