package com.rxjava.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rxjava.model.Student;
import com.rxjava.repository.StudentRepository;

public class StudentServiceTest {
	
	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentService studentService;
	
	@Captor
	private ArgumentCaptor<Student> studentArgument;
	
	public StudentServiceTest() {

		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreated() {
		
		studentService.save(new Student());
		
		verify(studentRepository).save(studentArgument.capture());

		assertThat(studentArgument.getValue().getIdStudent(), is(notNullValue()));

	}

}
