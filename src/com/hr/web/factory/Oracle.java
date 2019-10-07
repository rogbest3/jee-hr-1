package com.hr.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import com.hr.web.enums.DRIVER;
import com.hr.web.enums.URL;
import com.hr.web.pool.Constants;

public class Oracle implements Database{

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER.ORACLE_DRIVER.toString());
			conn = DriverManager.getConnection(URL.ORACLE_URL.toString(),
					Constants.USERNAME,
					Constants.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
