package c195_2.main.login;

import c195_2.main.Entity;

public class User extends Entity {
	
	public int userId;
	public String userName;
	public String password;
	public boolean active;
	
	@Override
	public String toString() {
		return userName;
	}
	

}
