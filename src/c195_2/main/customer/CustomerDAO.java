package c195_2.main.customer;

import c195_2.main.login.User;

public interface CustomerDAO {

	public Customer addOrUpdate(Customer customer);
	public Customer find(Integer id);
	public boolean delete(Integer id);
	
}
