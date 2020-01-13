package c195_2.main.appointment;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
	public boolean delete(Integer id) {
		String sql = "delete from appointment where appointmentId = ?" ;
		util.insert(sql, id+"");
		return true;
	}

	@Override
	public List<Appointment> findByUserAndDay(Integer userId, Date date) {
		
		Appointment a = new Appointment();
		a.startTime = new Date(0);
		a.endTime = new Date(System.currentTimeMillis());
		a.description = "Bad a description";
		a.title = "Very important meenting";
		
		Appointment b = new Appointment();
		b.startTime = new Date(0);
		b.endTime = new Date(System.currentTimeMillis());
		b.title = "Title is the best";
		b.description = "Better Descrpito-";
		ArrayList<Appointment> arrayList = new ArrayList<Appointment>();
		arrayList.add(a);
		arrayList.add(b);
		return arrayList;
	}

}
