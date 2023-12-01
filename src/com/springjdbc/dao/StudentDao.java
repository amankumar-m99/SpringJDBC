package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entity.Student;

public interface StudentDao {
	public void createTable();
	public Student getStudentById(int id);
	public List<Student> getStudents();
	public int insert(Student student);
	public int update(Student student);
	public int delete(int id);
}
