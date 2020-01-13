package c195_2.main.customer;

import java.util.List;

public interface CustomerDAO {

	public Customer addOrUpdate(Customer customer);
	public Customer find(Integer id);
	public boolean delete(Integer id);
	public List<Customer> getCustomers();
	
}
