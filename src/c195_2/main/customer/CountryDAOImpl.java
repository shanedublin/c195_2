package c195_2.main.customer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import c195_2.main.database.DBUtil;

public class CountryDAOImpl implements CountryDAO{

	public DBUtil util = new DBUtil();
	
	@Override
	public Country addOrUpdate(Country c) {
		String sql = "";
		Date d = new Date(System.currentTimeMillis());
		if(c.countryId == null) {
			sql = "insert into country (country, createDate, createdBy, lastUpdate, lastUpdateBy) values(?,?,?,?,?)";
		} else {
			sql = "update country set country = ?, createDate = ?, createdBy = ?, lastUpdate = ?, lastUpdateBy = ? where countryId = " + c.countryId;
		}
		Integer id = util.insert(sql, c.country,d.toString(), "Shane", d.toString(),"Shane");
		if(c.countryId == null) {
			c.countryId = id;
		}
		return c;
	}

	@Override
	public boolean delete(Country c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Country find(Country c) {
		String sql = "Select countryId, country from country c where c.country like ?";
		ResultSet queryDatabase = util.queryDatabase(sql, c.country);
		// TODO Auto-generated method stub;
		c = new Country();
		try {
			while (queryDatabase.next()) {
				c.country = queryDatabase.getString("country");
				c.countryId = Integer.parseInt( queryDatabase.getString("countryId"));
				System.out.println(c);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return c;
	}
	
	

}
