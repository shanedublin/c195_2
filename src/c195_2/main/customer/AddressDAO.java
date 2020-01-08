package c195_2.main.customer;

public interface AddressDAO {

 	Address addOrUpdate(Address a);

	boolean delete(Address a);

	Address find(Address a);
}
