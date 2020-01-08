package c195_2.main.customer;

import java.sql.Date;
import java.sql.ResultSet;

import c195_2.main.database.DBUtil;
import c195_2.main.login.User;

public class CustomerDAOImpl implements CustomerDAO {
	
	
	DBUtil util = new DBUtil();

	@Override
	public Customer addOrUpdate(Customer c) {
		String sql;
		if(c.customerId == null) {
			sql = "insert into customer (customerName, addressId, active, createDate, createdBy, lastUpdate, lastUpdateBy) values(?,?,?,?,?,?,?)";
		} else {
			sql = "update customer set customerName = ?, addressId = ?, active = ?, createDate = ?, createdBy = ?, lastUpdate = ?, lastUpdateBy = ? where customerId = " + c.customerId;
		}
		
		Date d = new Date(System.currentTimeMillis());
		Integer id = util.insert(sql, c.getCustomerName(),c.addressId +"", c.active +"",d.toString(), "Shane", d.toString(),"Shane");
		if(c.customerId == null) {
			c.customerId = id;
		}

		return c;
	}

	@Override
	public Customer find(Integer customer) {
		String sql = "Select customerId, customerName, addressId from customer c where c.customerId = ?";
		ResultSet queryDatabase = util.queryDatabase(sql, customer+"");
		Customer c = new Customer();
		try {
			while (queryDatabase.next()) {
				c.customerId = queryDatabase.getInt("customerId");
				c.customerName = queryDatabase.getString("country");
				c.addressId = Integer.parseInt( queryDatabase.getString("addressId"));
				System.out.println(c);
				return c;
				//break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "delete from customer where customerId = ?" ;
		util.insert(sql, id+"");
		return true;
	}
	
	
	

}
