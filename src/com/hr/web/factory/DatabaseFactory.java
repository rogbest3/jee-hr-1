package com.hr.web.factory;

public class DatabaseFactory {
	public static Database createDatabase(String vendor) {
		return new Oracle();
	}
}
