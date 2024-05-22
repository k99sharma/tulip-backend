package com.k99sharma.tulip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class TulipConfigurationTest {
	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDatabaseConnection(){
		try(Connection connection = dataSource.getConnection()){
			assert connection != null;
			System.out.println("Database connection established.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
