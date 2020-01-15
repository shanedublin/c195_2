package c195_2.main.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import c195_2.main.database.DBUtil;

public class UserDAOImpl implements UserDAO {

	DBUtil util = new DBUtil();

	@Override
	public User addOrUpdate(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User validateUser(User u) {

		String sql = "select * from user where userName = ? and password = ?";
		ResultSet rs = util.queryDatabase(sql, u.userName, u.password);
		try {
			while (rs.next()) {
				u.userId = rs.getInt("userId");
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<User> getUsers() {
		String sql = "select userId, userName from user";

		ResultSet rs = util.queryDatabase(sql);
		List<User> list = new ArrayList<User>();
		try {
			while (rs.next()) {
				User u = new User();
				u.userId = rs.getInt("userId");
				u.userName = rs.getString("userName");
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
