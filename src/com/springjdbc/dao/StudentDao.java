package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entity.Student;

public interface StudentDao {

	public void createTable();

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

	public int insert(Student student);

	public int update(Student student);

	public int deleteById(int id);

}
