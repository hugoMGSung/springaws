package com.hugo83.appec2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppEc2ApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pStatement = conn.prepareStatement("SELECT now()");
			ResultSet rSet = pStatement.executeQuery();
			rSet.next();
			System.out.println(">>>>>>>>>>>>>>>>> " + rSet.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
