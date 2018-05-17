package com.ejemplo.spring.data.jdbc;

import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.mapping.event.AfterSaveEvent;
import org.springframework.data.jdbc.mapping.model.NamingStrategy;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ejemplo.spring.data.jdbc.entities.Factura;

@Configuration
// Anotacion de busqueda de interfaces que hereden de la jerarquia de
// CrudRepository
@EnableJdbcRepositories
@ComponentScan("com.ejemplo.spring.data.jdbc.services")
@EnableTransactionManagement
public class SpringConfiguration {

	@Bean
	public ApplicationListener<AfterSaveEvent> timeStampingSaveTime() {
		return new ApplicationListener<AfterSaveEvent>() {

			@Override
			public void onApplicationEvent(AfterSaveEvent event) {
				System.out.println("DESPUES DE GUARDAR UNA FACTURA: " + event.getEntity());				
			}
		};
	}
	
	@Bean
	public NamingStrategy namingStrategy(){
		return new NamingStrategy() {
			//Cambio de nombres de tablas
			public String getTableName(Class<?> type) {
				// TODO Auto-generated method stub
				return NamingStrategy.super.getTableName(type);
			}
			
			//Cambio de nombre de tablas precedido de schema
			public String getQualifiedTableName(Class<?> type) {
				// TODO Auto-generated method stub
				return NamingStrategy.super.getQualifiedTableName(type);
			}
		};
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Autowired
	public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public DataSource datasource() {
		SimpleDriverDataSource ds = new SimpleDriverDataSource(new ClientDriver(),
				"jdbc:derby://localhost:1527/facturas", "user", "user");
		ds.setSchema("APP");
		return ds;
	}

	/*
	 * @Bean RowMapperMap rowMappers() { return new ConfigurableRowMapperMap()
	 * .register(Factura.class, new FacturaRowMapper()); }
	 */

}
