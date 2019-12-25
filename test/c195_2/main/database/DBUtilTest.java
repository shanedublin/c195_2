package c195_2.main.database;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class DBUtilTest {

	
	DBUtil util;
	
	@Before
	public void beforeEach() {
		util = new DBUtil();
	}
	
	@Test
	public void test() {
		
		Date d = new Date(System.currentTimeMillis());
		util.insert("insert into country (country, createDate, createdBy, lastUpdateBy) values (?,?,?,?)", "Mexico" ,d.toString(), "Shane","Tester");
//		util.queryDatabase("test");
	}

}
