package com.assignment.studentapp.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.assignment.studentapp.model.Student;

@Repository
public interface StudentRepository extends R2dbcRepository<Student, Long> {
	
}
