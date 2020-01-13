package c195_2.main.login;

import java.util.List;

public interface UserDAO {

	public User addOrUpdate(User user);
	public User find(Integer id);
	public List<User> getUsers();
	public boolean delete(Integer id);
}
