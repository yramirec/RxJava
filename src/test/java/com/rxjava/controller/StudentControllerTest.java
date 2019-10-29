package com.rxjava.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rxjava.model.Student;
import com.rxjava.service.StudentService;

public class StudentControllerTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.buildMockstudentOrder();
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	private void buildMockstudentOrder() {

		Student student1 = new Student();
		student1.setIdStudent("ST001");
		student1.setName("Julian");
		student1.setLastname("Salazar");
		student1.setAge(25);

		Student student2 = new Student();
		student2.setIdStudent("ST002");
		student2.setName("Fernando");
		student2.setLastname("Gonzales");
		student2.setAge(53);

		// System.out.println(student1);
		// System.out.println(student2);
		
		System.out.println("---------------------------------------");
		System.out.println("LIST STUDENT");
		System.out.println("---------------------------------------");
		
		System.out.println("STUDENT 1");
		System.out.println(
				"Id: "+ student1.getIdStudent() 
		        + "\n" + "FirstName: " + student1.getName() 
		        + "\n" + "LastName: "	+ student1.getLastname() 
		        + "\n" + "Age: " + student1.getAge());

		System.out.println("");
		System.out.println("STUDENT 2");
		System.out.println(
				"Id: "+ student2.getIdStudent() 
		        + "\n" + "FirstName: " + student2.getName() 
		        + "\n" + "LastName: "	+ student2.getLastname() 
		        + "\n" + "Age: " + student2.getAge());

	}

}
