package com.rxjava.repository;

import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

import com.rxjava.model.Student;

@Repository
public interface StudentRepository extends RxJava2CrudRepository<Student, String> {

	
}
