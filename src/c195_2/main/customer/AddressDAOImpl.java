package c195_2.main.customer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import c195_2.main.database.DBUtil;

public class AddressDAOImpl implements AddressDAO{

	public DBUtil util = new DBUtil();
	
	@Override
	public Address addOrUpdate(Address c) {
		String sql = "";
		if(c.addressId == null) {
			sql = "insert into address (address, address2, postalCode, phone, cityId, createDate, createdBy, lastUpdate, lastUpdateBy) values(?,?,?,?,?,?,?,?,?)";
		} else {
			sql = "update address set address = ?, address2 = ?, postalCode = ?, phone = ?, cityId = ?, createDate = ?, createdBy = ?, lastUpdate = ?, lastUpdateBy = ? where addressId = " + c.addressId;
		}
		
		Date d = new Date(System.currentTimeMillis());
		Integer id = util.insert(sql, c.address,c.address2, c.postalCode, c.phone, c.cityId +"", d.toString(), "Shane", d.toString(),"Shane");
		if(c.addressId == null) {
			c.addressId = id;
		}
		return c;
	}

	@Override
	public boolean delete(Address c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address find(Address c) {
		String sql = "Select addressId, address from address c where c.addressId = ?";
		ResultSet queryDatabase = util.queryDatabase(sql, c.addressId +"");
		// TODO Auto-generated method stub;
		c = new Address();
		try {
			while (queryDatabase.next()) {
				c.address = queryDatabase.getString("address");
				c.addressId = Integer.parseInt( queryDatabase.getString("addressId"));
				System.out.println(c);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return c;
	}
	
	

}

