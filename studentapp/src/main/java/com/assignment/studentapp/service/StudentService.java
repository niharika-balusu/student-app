package com.assignment.studentapp.service;

import com.assignment.studentapp.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
	public Flux<Student> getAllStudents();

	public Mono<Student> getStudentById(Long id);

	public Mono<Student> createStudent(Student student);

	public Mono<Object> deleteStudent(Long id);

	public Mono<Student> updateStudent(Long id, Student student);
}
