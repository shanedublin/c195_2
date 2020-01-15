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
import java.util.List;
import java.util.TimeZone;

import c195_2.main.database.DBUtil;

public class AppointmentDAOImpl implements AppointmentDAO {

	DBUtil util = new DBUtil();
	SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
	SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
				Appointment a = new Appointment();
				a.appointmentId  = rs.getInt("appointmentId");
				a.title = rs.getString("title");
				a.customerId = rs.getInt("customerId");
				a.userId = rs.getInt("userId");
				a.description = rs.getString("description");
				a.location = rs.getString("location");
				a.contact = rs.getString("contact");
				a.type = rs.getString("type");
				a.url = rs.getString("url");
				a.startTime = rs.getTimestamp("start");
				LocalDate convertedDate = ZonedDateTime.of(a.startTime.toLocalDateTime(), ZonedDateTime.now().getZone()).toLocalDate();
				System.out.println(sdf.format(Date.valueOf(convertedDate)));
				a.endTime = rs.getTimestamp("end");
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
