package c195_2.main.customer;

public interface CityDAO {

	City addOrUpdate(City c);

	boolean delete(City c);

	City find(City c);

}
