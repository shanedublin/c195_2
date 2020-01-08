package c195_2.main.customer;

import c195_2.main.login.User;

public interface CustomerDAO {

	public Customer add(Customer customer);
	public Customer update(Customer customer);
	public boolean delete(Customer customer);
	
}
