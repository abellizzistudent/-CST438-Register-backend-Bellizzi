package com.cst438.controller;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.Course;
import com.cst438.domain.Enrollment;
import com.cst438.domain.ScheduleDTO;
import com.cst438.domain.Student;
import com.cst438.domain.StudentDTO;

@RestController
public class StudentController {

//For development testing, variables here will need to be removed
	String email ="test@test.com";
	String name ="First Last";
	
	@PostMapping("/student")
	@Transactional	
//Method that is called when POST request is made
	public StudentDTO addStudent(@RequestBody StudentDTO studentData) {
		StudentDTO sdto = studentData;
		return sdto;
	}
	
//Method called when PUT request is made to modify existing student
	//For Admin, change status to hold
	@PutMapping("/student/{statusCode}")
	@Transactional
	public StudentDTO holdStudent(@RequestBody StudentDTO studentStatus) {
		StudentDTO sdto = studentStatus;
		return sdto;
	}
	
//Method called when PUT request is made to modify existing student
	//For Admin, change status to hold
	@DeleteMapping("/student/{statusCode}")
	@Transactional
	public void deleteStudent(@PathVariable int student_id) {
		
		}

}