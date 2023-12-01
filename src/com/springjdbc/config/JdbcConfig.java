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
		return new Student(1, "no_name", "no_city");
	}

	@Bean("dataSource")
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
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

	@Bean("studentDaoImpl")
	public StudentDao getStudentDaoImpl() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl(getJdbcTemplate());
		return studentDaoImpl;
	}
}
