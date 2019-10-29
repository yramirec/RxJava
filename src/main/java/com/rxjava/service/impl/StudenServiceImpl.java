package com.rxjava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxjava.model.Student;
import com.rxjava.repository.StudentRepository;
import com.rxjava.service.StudentService;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;



@Service
public class StudenServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Flowable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Maybe<Student> findById(String idStudent) {
		return studentRepository.findById(idStudent);
	}

	@Override
	public Single<Student> save(Student student) {
		return studentRepository.save(student); 
	}

	@Override
	public Single<Student> update(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Completable delete(String idStudent) {
		return studentRepository.deleteById(idStudent);
	}


		
}