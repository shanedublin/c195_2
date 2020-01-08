package c195_2.main.customer;

import c195_2.main.database.DBUtil;

public interface AddressDAO {

 	Address addOrUpdate(Address a);

	boolean delete(Address a);

	Address find(Address a);
}
