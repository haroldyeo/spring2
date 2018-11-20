package com.harold.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.harold.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// set up a variable to hold the properties
	@Autowired
	private Environment env;
	
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	// define a bean for a view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// define a bean for datasource
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDs = new ComboPooledDataSource();
		
		// set driver
		try {
			securityDs.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// some logging
		LOGGER.info("jdbc userName: "+env.getProperty("jdbc.user"));
		LOGGER.info("jdbc url: "+env.getProperty("jdbc.url"));
		
		
		securityDs.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDs.setUser(env.getProperty("jdbc.user"));
		securityDs.setPassword(env.getProperty("jdbc.password"));
		
		
		securityDs.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDs.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDs.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDs.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDs;
	}
	
	
	// Helper method to convert property in int
	public int getIntProperty(String property) {
		String propVal = env.getProperty(property);
		int propInt = Integer.parseInt(propVal);
		return propInt;
	}
	
}
