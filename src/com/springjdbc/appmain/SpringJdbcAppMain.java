package com.springjdbc.appmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.config.JdbcConfig;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

public class SpringJdbcAppMain {
	public static void main(String[] args) {
		launchByXmlConfig();
		launchByAnnotation();
	}

	private static void launchByXmlConfig(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/resources/config.xml");
		performOperations(context);
		((ClassPathXmlApplicationContext)context).close();
	}

	private static void launchByAnnotation() {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		performOperations(context);
		((AnnotationConfigApplicationContext)context).close();
	}

	private static void performOperations(ApplicationContext context) {
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		studentDao.createTable();
		Student student = context.getBean("student", Student.class);
		int row = studentDao.insert(student);
		System.out.println("inserted "+ row + " records.");

		System.out.println("--------------------------------------");

		System.out.println("Printng all records so far...");
		for(Student s: studentDao.getAllStudents()) {
			System.out.println(s);
		}

		int id = 1;
		System.out.println("Getting student by id " + id);
		student = studentDao.getStudentById(id);
		if(student != null) {
			//updating city
			student.setCity("New York");
			studentDao.update(student);
			System.out.println("Student with id "+ id + " city updated");
			System.out.println(student);
			System.out.println("Deleting this student...");
			studentDao.deleteById(id);
			System.out.println("Student with id "+ id + " deleted");
		}
		else {
			System.out.println("No student found by id " + id);
		}
	}
}
