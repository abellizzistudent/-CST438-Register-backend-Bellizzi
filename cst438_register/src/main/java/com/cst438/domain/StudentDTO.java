package com.cst438.domain;


public class StudentDTO {
	public int id;
	public String studentEmail;
	public String studentName;
	
	public StudentDTO() {
		this.id = 0;
		this.studentEmail=null;
		this.studentName=null;
	}
	
	
	public StudentDTO(String studentEmail, String studentName) {
		this.id = 0;
		this.studentEmail=studentEmail;
		this.studentName=studentName;
	}


	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", studentEmail=" + studentEmail + ", studentName=" + studentName
				+"]";
	}
	
}