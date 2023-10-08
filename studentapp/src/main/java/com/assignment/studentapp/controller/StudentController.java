package com.assignment.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.studentapp.model.Student;
import com.assignment.studentapp.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public Flux<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Mono<Student> getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@PostMapping
	public Mono<Student> createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PutMapping("/{id}")
	public Mono<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public Mono<Object> deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
}
