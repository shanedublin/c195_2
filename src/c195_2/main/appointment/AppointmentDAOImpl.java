package c195_2.main.appointment;

import java.sql.Date;

import c195_2.main.database.DBUtil;

public class AppointmentDAOImpl implements AppointmentDAO {

	DBUtil util = new DBUtil();
	
	@Override
	public Appointment addOrUpdate(Appointment a) {

		String sql = "";
		if(a.appointmentId == null) {
			sql = "insert into appointment (title, customerId, userId, description, location, contact, type, url, start, end, createDate, createdBy, lastUpdate, lastUpdateBy) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		} else {
			sql = "update appointment set title = ?, customerId = ?, userId = ?, description = ?, location = ?, contact = ?, type = ?, url = ?, start = ?, end = ?, createDate = ?, createdBy = ?, lastUpdate = ?, lastUpdateBy = ? where appointmentId = " + a.appointmentId;
		}
		
		Date d = new Date(System.currentTimeMillis());
		Integer id = util.insert(sql, a.title, a.customerId + "", a.userId + "",
				a.description, a.location, a.contact, a.type, a.url, a.startTime.toString(), a.endTime.toString(), d.toString(), "Shane", d.toString(),"Shane");
		if(a.appointmentId == null) {
			a.appointmentId = id;
		}
		return a;
		
	}

	@Override
	public Appointment find(Appointment a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Appointment a) {
		// TODO Auto-generated method stub
		return false;
	}

}
