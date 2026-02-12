package com.xantrix.webapp.repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() throws SQLException{
		
		PGSimpleDataSource ds = new PGSimpleDataSource();
		ds.setServerNames(new String[] { "localhost" });
		ds.setPortNumbers(new int[] { 5432 });
		ds.setUser("myuser");
		ds.setPassword("mypassword");
		ds.setDatabaseName("mydb");
		ds.setSsl(true);
		ds.setSslMode("allow");

		return  ds;
	}
	
	public Connection connection(DataSource dataSource) throws SQLException{
		
		return dataSource.getConnection();
	}
}
