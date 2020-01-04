package c195_2.main.customer;

import c195_2.main.login.User;

public interface CustomerDAO {

	public Customer add(Customer user);
	public Customer update(Customer user);
	public boolean delete(Customer user);
	
}
