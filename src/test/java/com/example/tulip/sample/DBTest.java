package com.example.tulip.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class DBTest {
    @Autowired
    DataSource dataSource;

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
