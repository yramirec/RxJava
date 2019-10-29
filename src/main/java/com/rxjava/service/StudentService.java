package com.rxjava.service;

import com.rxjava.model.Student;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface StudentService {
	
	Flowable<Student> findAll();
	Maybe<Student> findById(String idStudent);
	Single<Student> save(Student student);
	Single<Student> update(Student student);
	Completable delete(String idStudent);	

	/*
	Completable -> No maneja objetos.
	Single -> Maneja un solo objeto que no puede ser nulo.
	Maybe -> Maneja un solo objeto que puede ser nulo.
	Observable -> Maneja flujos infinitos.
	Flowable -> Maneja flujos infinitos con Backpresure
	*/
	
}
