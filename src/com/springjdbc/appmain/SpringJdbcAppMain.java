package com.springjdbc.appmain;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.config.JdbcConfig;
import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.entity.Student;

public class SpringJdbcAppMain {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/resources/config.xml");
//		StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);
//		Student student = context.getBean("student", Student.class);
//		studentDaoImpl.insert(student);
//		student.setId(1234);
//		int row = studentDaoImpl.insert(student);
//		System.out.println("inserted "+ row + " records.");
//		Student student = studentDaoImpl.getStudentById(1);
//		student.setCity("New York");
//		studentDaoImpl.update(student);
//		System.out.println(student);
//		studentDaoImpl.delete(300);
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);
		List<Student> allStudents = studentDaoImpl.getAllStudents();
		for(Student student: allStudents) {
			System.out.println(student);
		}
	}
}
