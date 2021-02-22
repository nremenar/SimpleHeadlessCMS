package com.angryram.cms.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
public class DbConfig {
	
	@Autowired
	Environment iEnv;
	
	final static Logger logger = LoggerFactory.getLogger(DbConfig.class);
	
	public String getProperty(final String pKey) {
		return iEnv.getProperty(pKey);
		
	}
		
	@Primary
	@Bean(name="dbCms")
	@Autowired
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(iEnv.getProperty("cms.datasource.url"));
	    dataSource.setUsername(iEnv.getProperty("cms.datasource.username"));
	    dataSource.setPassword(iEnv.getProperty("cms.datasource.password"));
		return dataSource;
	}
	@Primary
	@Bean(name={"jdbcCms"})
	@Autowired
	public JdbcTemplate jdbcTemplate(@Qualifier("dbCms") DataSource pDataSource) {
		  return new JdbcTemplate(pDataSource);
	}
}
