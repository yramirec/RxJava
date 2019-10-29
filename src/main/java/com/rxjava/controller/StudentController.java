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

import com.rxjava.exception.StudentException;
import com.rxjava.model.Student;
import com.rxjava.service.StudentService;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/*
	 * Method by List Student
	 */
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public Flowable<Student> findAll() {
		return studentService.findAll();
	}
	
	/*
	 * Method by List for id of Student
	 */
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Maybe<Student> findById(@PathVariable String idStudent) {
		return studentService.findById(idStudent);
	}

	/*
	 * Method by Create Student
	 */
	@PostMapping(
			value = "/students", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(
			value = "Registrar Student.", 
			httpMethod = " POST ", 
			notes = "classpath:swagger/notes/insurance-create.md")
	@ApiResponses({ @ApiResponse(
			code = 201, 
			message = "Se guardó el registro con exito", 
			response = Student.class),
			@ApiResponse(
					code = 501, 
					message = "Funcionalidad no implementada.", 
					response = StudentException.class),
			@ApiResponse(
					code = 500,
					message = " Error al realizar la validación; previa de datos.", 
					response = StudentException.class) })
	public Single<Student> save(Student student) {
		return studentService.save(student);
	}	
	
	
	/*
	 * Method by Update Student
	 */
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Single<Student> update(Student student) {
		return studentService.save(student);
	}

	/*
	 * Method by Delete Student
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Completable delete(String idStudent) {
		return studentService.delete(idStudent);
	}
	
}
