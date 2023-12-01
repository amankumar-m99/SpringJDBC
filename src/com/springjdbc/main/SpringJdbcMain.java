package com.springjdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.entity.Student;

public class SpringJdbcMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/resources/config.xml");
//		Student student = context.getBean("student", Student.class);
		StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);
//		student.setId(1234);
//		int row = studentDaoImpl.insert(student);
//		System.out.println("inserted "+ row + " records.");
		Student student = studentDaoImpl.getStudentById(106);
		System.out.println(student);
	}
}
