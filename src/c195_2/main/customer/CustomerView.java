package c195_2.main.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerView {
	
	public Customer customer = new Customer();
	public Country country = new Country();
	public City city = new City();
	public Address address = new Address();
	
	@Override
	public String toString() {
		return customer.toString() +" "+  address.toString() + " "  + city.toString() + " " + country.toString();
	}
	public CustomerView() {
	}
	
	public CustomerView(ResultSet rs) {
		
		try {
			this.customer.customerId =  rs.getInt("customerId");
			this.customer.customerName = rs.getString("customerName");
			this.customer.addressId = rs.getInt("addressId");
			
			this.country.countryId =  rs.getInt("countryId");
			this.country.country = rs.getString("country");
			
			this.city.cityId =  rs.getInt("cityId");
			this.city.city = rs.getString("city");
			
			this.address.addressId =  rs.getInt("addr.addressId");
			this.address.address = rs.getString("addr.address");
			this.address.address2 = rs.getString("addr.address2");
			this.address.phone = rs.getString("addr.phone");
			this.address.postalCode = rs.getString("addr.postalCode");
			
			System.out.println(this.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
