package com.springjdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.entity.Student;

@Configuration
public class JdbcConfig {

	@Bean("student")
	public Student getStudent() {
		return new Student(0, "s_name", "s_city");
	}

	@Bean("dataSource")
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/02_spring_jdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManagerDataSource());
		return jdbcTemplate;
	}

	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDao StudentDao = new StudentDaoImpl(getJdbcTemplate());
		return StudentDao;
	}
}
