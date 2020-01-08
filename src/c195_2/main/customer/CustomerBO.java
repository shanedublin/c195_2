package c195_2.main.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import c195_2.main.database.DBUtil;

public class CustomerBO {

	CityDAO cityDAO = new CityDAOImpl();
	CountryDAO countryDAO = new CountryDAOImpl();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	AddressDAO addressDAO = new AddressDAOImpl();
	DBUtil util = new DBUtil();
	String sql = "SELECT cus.customerId, cus.customerName, "
			+ "addr.addressId, addr.address, addr.address2, addr.cityId, addr.phone, addr.postalCode, "
			+ "city.cityId, city.city, "
			+ "country.countryId, country.country "
			+ "from customer cus "
			+ "INNER JOIN address addr on cus.addressId = addr.addressId "
			+ "INNER JOIN city city on addr.cityId = city.cityId "
			+ "INNER JOIN country country on city.countryId = country.countryId ";
	
	
	public CustomerView saveCustomer(CustomerView cv) {
		
		
		countryDAO.addOrUpdate(cv.country);
		cv.city.countryId = cv.country.countryId;
		
		cityDAO.addOrUpdate(cv.city);
		cv.address.cityId = cv.city.cityId;
		
		addressDAO.addOrUpdate(cv.address);
		cv.customer.addressId = cv.address.addressId;
		
		customerDAO.addOrUpdate(cv.customer);
				
	
		return cv;
			
	}
	
	public List<CustomerView> loadCustomers(){
		List<CustomerView> list = new ArrayList<CustomerView>();
		ResultSet rs = util.queryDatabase(sql);
		try {
			while(rs.next()) {
				list.add(new CustomerView(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public CustomerView loadCustomer(Integer id) {
		
		String query = sql + "WHERE cus.customerId = ?;";
		
		System.out.println(query);
		ResultSet rs = util.queryDatabase(query, id + "");
		
		
		try {
			while(rs.next()) {				
				return new CustomerView(rs);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
}
