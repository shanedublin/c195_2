package c195_2.main.customer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import c195_2.main.database.DBUtil;

public class CityDAOImpl implements CityDAO{

	public DBUtil util = new DBUtil();
	
	@Override
	public City addOrUpdate(City c) {
		
		String sql = "insert into city (city, countryId, createDate, createdBy, lastUpdate, lastUpdateBy) values(?,?,?,?,?,?)";
		Date d = new Date(System.currentTimeMillis());
		util.insert(sql, c.city,c.countryId +"", d.toString(), "Shane", d.toString(),"Shane");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(City c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public City find(City c) {
		String sql = "Select cityId, city from city c where c.city like ?";
		ResultSet queryDatabase = util.queryDatabase(sql, c.city);
		// TODO Auto-generated method stub;
		c = new City();
		try {
			while (queryDatabase.next()) {
				c.city = queryDatabase.getString("city");
				c.cityId = Integer.parseInt( queryDatabase.getString("cityId"));
				System.out.println(c);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return c;
	}
	
	

}
