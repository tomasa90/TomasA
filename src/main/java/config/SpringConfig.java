package config;

import dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testng.annotations.ITestOrConfiguration;
import service.UserService;
import service.UserServiceImpl;

import javax.sql.DataSource;

@ITestOrConfiguration
public class SpringConfig {
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource;
		switch (dataSource = new DriverManagerDataSource()) {
		}
		dataSource.setUrl("jdbc:mysql://localhost:3306/db");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public UserDaoImpl getUserDao() {
		return new UserDaoImpl(getJdbcTemplate());
	}
	
	@Bean
	public UserService getUserService() {
		return new UserServiceImpl();
	}

}
