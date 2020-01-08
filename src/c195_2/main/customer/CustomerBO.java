package c195_2.main.customer;

public class CustomerBO {

	CityDAO cityDAO = new CityDAOImpl();
	CountryDAO countryDAO = new CountryDAOImpl();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	AddressDAO addressDAO = new AddressDAOImpl();
	
	
	
	public void saveCustomer(Customer customer, Country country, City city, Address address) {
		
		Country countryFind = countryDAO.find(country);
		if(countryFind.countryId == null) {
			countryDAO.addOrUpdate(country);
			countryFind = countryDAO.find(country);
		}
		
		City cityFind = cityDAO.find(city);
		if(cityFind.cityId == null) {
			city.countryId = countryFind.countryId;
			cityDAO.addOrUpdate(city);
			cityFind = cityDAO.find(city);
		}
		
		Address addressFind = addressDAO.find(address);
		if(addressFind.addressId == null) {
			address.cityId = cityFind.cityId;
			addressDAO.addOrUpdate(address);
			addressFind = addressDAO.find(address);
		}
		customer.addressId = addressFind.addressId;
		customerDAO.add(customer);
		
		
	}
}
