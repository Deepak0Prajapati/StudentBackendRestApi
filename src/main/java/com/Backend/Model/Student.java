package com.Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rollno;
	
	@NotBlank(message = "Name can't be empty!")
	private String name;
	
	@NotBlank(message = "Email can't be empty!")
	private String email;
	
	@NotBlank(message = "Mobile No. can't be empty!")
	private String mobileno;
	
	
	public Long getRollno() {
		return rollno;
	}
	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public Student(Long rollno, String name, String email, String mobileno) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", email=" + email + ", mobileno=" + mobileno + "]";
	}
	
	

}
