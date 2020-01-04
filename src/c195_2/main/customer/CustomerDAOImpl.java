package c195_2.main.customer;

import java.sql.Date;

import c195_2.main.database.DBUtil;
import c195_2.main.login.User;

public class CustomerDAOImpl implements CustomerDAO {
	
	
	DBUtil util = new DBUtil();

	@Override
	public Customer add(Customer c) {
		
		String sql = "insert into customer (customerName, addressId, active, createDate, createdBy, lastUpdate, lastUpdateBy) values(?,?,?,?,?,?,?)";
		Date d = new Date(System.currentTimeMillis());
		
		util.insert(sql, c.customerName,"1","true",d.toString(), "Shane", d.toString(),"Shane");
		
		//util.insert("insert into country (country, createDate, createdBy, lastUpdateBy) values (?,?,?,?)", "Mexico" ,d.toString(), "Shane","Tester");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
