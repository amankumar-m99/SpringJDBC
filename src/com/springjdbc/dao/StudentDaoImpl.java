package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createTable() {
		String query = "create table if not exists student (id serial primary key, name varchar(20), city varchar(20));";
		jdbcTemplate.execute(query);
	}

	@Override
	public Student getStudentById(int id) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new StudentRow();
		return this.jdbcTemplate.queryForObject(query, rowMapper, id);
	}

	@Override
	public List<Student> getAllStudents(){
		String query = "select * from student";
		RowMapper<Student> rowMapper = new StudentRow();
		return this.jdbcTemplate.query(query, rowMapper);
	}

	@Override
	public int insert(Student student) {
		String query = "insert into student (id, name, city) values (?, ?, ?);";
		return jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
	}

	@Override
	public int update(Student student) {
		String query = "update student set name=? , city=? where id=?";
		return jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
	}

	@Override
	public int delete(int id) {
		String query="delete from student where id=?";
		return jdbcTemplate.update(query, id);
	}
}
