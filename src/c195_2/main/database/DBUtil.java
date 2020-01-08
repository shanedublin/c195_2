package c195_2.main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static Connection conn = null;
//	private Statement stmt = null;

	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://3.227.166.251/U051Ai";

	// Database credentials
	final String DBUSER = "U051Ai";
	final String DBPASS = "53688406683";
	
	public Integer insert(String sql, String... params) {
		conn = getConnection();
		try {
			PreparedStatement prepareStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < params.length; i++) {
				String string = params[i];
				if(string.equalsIgnoreCase("true")) {
					prepareStatement.setInt(i+1, 1);
				} else {
					prepareStatement.setString(i+1, string);
					
				}
			}
			System.out.println(prepareStatement.toString());
			prepareStatement.executeUpdate();
			ResultSet rs = prepareStatement.getGeneratedKeys();
			{
				if(rs.next()) {
					return (int) rs.getLong(1);
				}
			}
			//			stmt.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			//closeConnection();
		}
		return -1;
	}

	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Getting connection");
			if(conn == null) {
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void closeConnection() {
		try {
			if (conn != null) {
				System.out.println("Closing connection");
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public ResultSet queryDatabase(String sql, String... params) {
		conn = getConnection();
		try {
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				String string = params[i];
				if(string.equalsIgnoreCase("true")) {
					prepareStatement.setInt(i+1, 1);
				} else {
					prepareStatement.setString(i+1, string);
					
				}
			}
			System.out.println(prepareStatement.toString());
			ResultSet rs = prepareStatement.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			//closeConnection();
		}
		return null;

	}



}
