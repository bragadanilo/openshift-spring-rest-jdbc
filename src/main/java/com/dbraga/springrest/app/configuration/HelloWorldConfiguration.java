package com.dbraga.springrest.app.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dbraga.springrest.app.dao.PersonDAO;
import com.dbraga.springrest.app.dao.PersonDAOImpl;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.dbraga.springrest.app")
@PropertySource({ "classpath:database-local.properties" })
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/", "classpath:/other-resources/");
	}

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));

		if (env.getProperty("OPENSHIFT_APP_NAME") != null) {
			//
			// running in openshift server
			String host = env.getProperty("OPENSHIFT_MYSQL_DB_HOST");
			String port = env.getProperty("OPENSHIFT_MYSQL_DB_PORT");
			String dbName = env.getProperty("OPENSHIFT_APP_NAME");
			String dbUrl = String.format("jdbc:mysql://%s:%s/%s", host, port, dbName);
			
			dataSource.setUrl(dbUrl);
			dataSource.setUsername(env.getProperty("OPENSHIFT_MYSQL_DB_USERNAME"));
			dataSource.setPassword(env.getProperty("OPENSHIFT_MYSQL_DB_PASSWORD"));
		} else {
			//
			// running in local machine
			dataSource.setUrl(env.getProperty("jdbc.url"));
			dataSource.setUsername(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.pass"));
		}

		return dataSource;
	}

	@Bean
	public PersonDAO getContactDAO() {
		return new PersonDAOImpl(getDataSource());
	}

}