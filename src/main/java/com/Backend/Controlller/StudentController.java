package com.Backend.Controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Exception.DeleteException;
import com.Backend.Exception.RegisterException;
import com.Backend.Model.Student;
import com.Backend.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl serviceImpl;
	
	
	//Creating new student
	@PostMapping("/students")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		
		try{
			serviceImpl.createStudent(student);
		
		}catch (Exception e) {
			throw new RegisterException();
		}
		
		return new ResponseEntity<String>("Student Created Successfully!!",HttpStatus.CREATED);
		
	}
	
	
	//Fetching All student details
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> student = serviceImpl.getStudent();
		
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
		
	}
	
	
	//fetching details of a single student
	@GetMapping("/students/{data}")
	public ResponseEntity<Student> getStudent(@PathVariable String data){
		
		Student student = serviceImpl.getSingleStudent(data);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	
	//updating student
	@PutMapping("/students/{data}")
	public ResponseEntity<Student> updateStudent(@PathVariable String data, @RequestBody Student student){
		
		Student updateStudent = serviceImpl.updateStudent(data, student);
		
		return new ResponseEntity<Student>(updateStudent,HttpStatus.OK);
		
	}
	
	//deleting student
		@DeleteMapping("/students/{data}")
		public ResponseEntity<String> deleteStudent(@PathVariable int data){
			
			try {
				serviceImpl.deleteStudent(data);
				return new ResponseEntity<String>("User Deleted!!",HttpStatus.OK);
			}catch (Exception e) {
				throw new DeleteException();
			}
		}

}
