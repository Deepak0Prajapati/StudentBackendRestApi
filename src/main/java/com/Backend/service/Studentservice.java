package com.Backend.service;

import java.util.List;

import com.Backend.Model.Student;


public interface Studentservice  {
	
	public Student createStudent(Student student);
	public List<Student> getStudent();
	public Student getSingleStudent(String data);
	public Student updateStudent(String data, Student student);
	public int deleteStudent(int data);

}
