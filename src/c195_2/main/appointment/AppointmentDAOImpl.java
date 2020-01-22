package c195_2.main.appointment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import c195_2.main.database.DBUtil;

public class AppointmentDAOImpl implements AppointmentDAO {

	DBUtil util = new DBUtil();
	public static SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
	public static SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	{
		sdfUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
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
				a.description, a.location, a.contact, a.type, a.url, 
				sdfUTC.format(a.startTime),
				sdfUTC.format(a.endTime),
				d.toString(), "Shane", d.toString(),"Shane");
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
		String sql = "select * from appointment where userId = ? and start between ? and ?"; 
		ResultSet rs = util.queryDatabase(sql, userId +"", date.toString(), date.toString()+":23:59:59");
		List<Appointment> list = new ArrayList<Appointment>();
		try {
			while (rs.next()) {
				Appointment a = new Appointment(rs);
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean appoinmentOverlaps(Appointment a) {
		
		String sql = "select * from appointment where (userId = ? or customerId = ?) and ? between start and end";
		
		if(a.appointmentId != null) {
			sql += " and appointmentId != " + a.appointmentId;
		}
		
		ResultSet rs = util.queryDatabase(sql, a.userId + "", a.customerId + "", sdfUTC.format(a.startTime)) ;
		try {
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Appointment in15Mins(Integer userId) {

		String sql = "select * from appointment where userId = ? and start between ? and ?";

		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp now15 = new Timestamp(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15));
		ResultSet rs = util.queryDatabase(sql, userId + "", sdfUTC.format(now), sdfUTC.format(now15));

		try {
			while(rs.next()) {
				Appointment a = new Appointment(rs);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentReport> getAppoinmentReport() throws SQLException{
		List<Appointment> appointmentList = getAllAppointments();
		
		Map<String, AppointmentReport> map = new HashMap<String, AppointmentReport>();
		appointmentList.stream().forEach(a-> {
			AppointmentReport ar = map.getOrDefault(a.type, new AppointmentReport());
			ar.number ++;
			ar.type = a.type;
			map.put(a.type, ar);
		});
		
		return new ArrayList<AppointmentReport>(map.values());
	}

	@Override
	public List<Appointment> getAllAppointments() {
		String sql = "select * from appointment";
		ResultSet rs = util.queryDatabase(sql);
		
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		try {
			while(rs.next()) {
				Appointment a = new Appointment(rs);
				appointmentList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointmentList;
	}

}
