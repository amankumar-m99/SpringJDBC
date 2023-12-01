package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entity.Student;

public class StudentRow implements RowMapper<Student>{

	private ApplicationContext context;
	public StudentRow() {
		this.context = new ClassPathXmlApplicationContext("com/springjdbc/resources/config.xml");
	}

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = context.getBean("student", Student.class);
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setCity(rs.getString(3));
		return student;
	}

}
