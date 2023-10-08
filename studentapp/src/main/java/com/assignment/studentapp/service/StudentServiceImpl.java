package com.assignment.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.studentapp.exception.StudentNotFoundException;
import com.assignment.studentapp.model.Student;
import com.assignment.studentapp.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;


	public Flux<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Mono<Student> getStudentById(Long id) {
		return studentRepository.findById(id)
				.switchIfEmpty(Mono.error(new StudentNotFoundException("Student not found with id: " + id)));
	}

	public Mono<Student> createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Mono<Object> deleteStudent(Long id) {
		return studentRepository.deleteById(id).then(Mono.empty())
				.onErrorResume(e -> Mono.error(new StudentNotFoundException("Student not found with id: " + id)));
	}

	public Mono<Student> updateStudent(Long id, Student student) {
		return studentRepository.findById(id).flatMap(existingStudent -> {
			existingStudent.setFirstname(student.getFirstname());
			existingStudent.setLastname(student.getLastname());
			return studentRepository.save(existingStudent);
		}).switchIfEmpty(Mono.error(new StudentNotFoundException("Student not found with id: " + id)));
	}
}
