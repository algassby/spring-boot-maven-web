package com.mycompany.invoise;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication

public class InvoiseWebApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InvoiseWebApplication.class, args);

	}
	@Bean
	public Hibernate5Module datHibernate5Module(){
		return  new Hibernate5Module();
	}

}
