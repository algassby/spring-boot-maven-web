package com.mycompany.invoise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication

public class InvoiseWebApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InvoiseWebApplication.class, args);
		DataSource ds = context.getBean(DataSource.class);
		Connection connection = null;
		try {
			connection = ds.getConnection();
			System.out.println("success");
			ResultSet rs = connection.createStatement().executeQuery("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE");
			while (rs.next()){
				System.out.println(rs.getLong("INVOICE_NUMBER")+ rs.getString("CUSTOMER_NAME"));
			}
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		finally {
			try {
				if (connection!=null){
					connection.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

}
