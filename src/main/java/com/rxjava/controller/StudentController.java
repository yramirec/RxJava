package com.rxjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rxjava.model.Student;
import com.rxjava.service.StudentService;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	
	@GetMapping()	
	@ResponseStatus(HttpStatus.OK)
	public Flowable<Student> findAll() {
		return studentService.findAll();
	}
	
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Maybe<Student> findById(@PathVariable String idStudent) {
		return studentService.findById(idStudent);
	}

	
	@PostMapping(
			value = "/students", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	
	public Single<Student> save(Student student) {
		return studentService.save(student);
	}	
	
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Single<Student> update(Student student) {
		return studentService.save(student);
	}

	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Completable delete(String idStudent) {
		return studentService.delete(idStudent);
	}
	
	
}