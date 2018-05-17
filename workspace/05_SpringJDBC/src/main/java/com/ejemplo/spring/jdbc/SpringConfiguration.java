package com.ejemplo.spring.jdbc;

import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan("com.ejemplo.spring.jdbc")
public class SpringConfiguration {
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSource datasource(){
		SimpleDriverDataSource ds = new SimpleDriverDataSource(new ClientDriver(), "jdbc:derby://localhost:1527/facturas", "user", "user");
		ds.setSchema("APP");
		return ds;
	}

}
