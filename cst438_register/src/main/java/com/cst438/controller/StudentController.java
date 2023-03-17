package com.cst438.controller;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cst438.domain.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;

//For development testing, variables here will need to be removed
	//String email ="test@test.com";
	//String name ="First Last";
	
	@PostMapping("/student")
	@Transactional	
//Method that is called when POST request is made
	public StudentDTO addStudent(@RequestBody StudentDTO student) { //client side DTO (rules defined by DTO class)
		//First look for email in DB dont dup an entry
		Student s = studentRepository.findByEmail(student.studentEmail);
		//if email does not exist, create new student
		if (s == null) {
			Student ns = new Student(); //DB side entity (subject to entity rules)
			ns.setName(student.studentName);
			ns.setEmail(student.studentEmail);
			ns = studentRepository.save(ns); //update ns obj with DB key
			student.id = ns.getStudent_id(); //
			return student;
		} else {
			throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, "Duplicate email in use.  " + student.studentEmail);
		}
	}
	
//As an administrator, I can put student registration on HOLD
	
//As an administrator, I can release the HOLD on student registration

}