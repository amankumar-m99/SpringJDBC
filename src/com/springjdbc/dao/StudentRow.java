package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entity.Student;

public class StudentRow implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt(1);
		String name=rs.getString(2);
		String city=rs.getString(3);
		Student student = new Student(id, name, city);
		return student;
	}
}
