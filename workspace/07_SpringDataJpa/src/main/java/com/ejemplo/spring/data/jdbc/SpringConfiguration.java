package com.ejemplo.spring.data.jdbc;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
//Anotacion de busqueda de interfaces que hereden de la jerarquia de CrudRepository
@ComponentScan("com.ejemplo.spring.data.jdbc.services")
@EnableJpaRepositories
public class SpringConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		
		emfb.setDataSource(dataSource());
		emfb.setJpaVendorAdapter(jpaVendorAdater());
		emfb.setPackagesToScan("com.ejemplo.spring.data.jdbc.entities");
		Properties jpaProperties = new Properties();
		
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.format_sql", "true");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");//create, update, validate
		jpaProperties.setProperty("hibernate.default_schema", "App");
		
		emfb.setJpaProperties(jpaProperties);
		return emfb;
	}
	
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdater() {
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean
	public DataSource dataSource(){
		SimpleDriverDataSource ds = new SimpleDriverDataSource(new ClientDriver(), "jdbc:derby://localhost:1527/facturas", "user", "user");
		ds.setSchema("APP");
		return ds;
	}
	
}
