package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

public class ConnectionSingleton {

	private static ConnectionSingleton instance;

	public static ConnectionSingleton getInstance() {
		if (instance == null)

			instance = new ConnectionSingleton();

		return instance;
	}

	private ConnectionSingleton() {
	}

	public Connection getConnection() throws SQLException{

			PGSimpleDataSource ds = new PGSimpleDataSource();
			ds.setServerNames(new String[] { "localhost" });
			ds.setPortNumbers(new int[] { 5432 });
			ds.setUser("myuser");
			ds.setPassword("mypassword");
			ds.setDatabaseName("mydb");
			ds.setSsl(true);
			ds.setSslMode("allow");

			return  ds.getConnection();

	}
}
