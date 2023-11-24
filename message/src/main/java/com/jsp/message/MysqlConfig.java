package com.jsp.message;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MysqlConfig {

	@Bean
	public HikariDataSource dataSource() {
		HikariConfig hikariConfig= new HikariConfig();
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/project_db");
		hikariConfig.setUsername("root");
		hikariConfig.setPassword("root");
		
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(HikariDataSource hikariDataSource) {
		return new JdbcTemplate(hikariDataSource);
	}
}
