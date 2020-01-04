package c195_2.main.customer;

public interface CountryDAO {
	
	

	public Country addOrUpdate(Country c);
	public Country find(Country c);
	public boolean delete(Country c);

}
