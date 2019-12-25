package c195_2.main.customer;

import c195_2.main.login.User;

public interface CustomerDAO {

	public User add(User user);
	public User update(User user);
	public boolean delete(User user);
	
}
