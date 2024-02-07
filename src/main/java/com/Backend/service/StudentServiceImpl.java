package com.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.Exception.DeleteException;
import com.Backend.Exception.UserNotFoundException;
import com.Backend.Model.Student;
import com.Backend.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements Studentservice {
	
	@Autowired
	private StudentRepository repository;

	@Override
	public Student createStudent(Student student) {
		
		return repository.save(student);
		
	}

	@Override
	public List<Student> getStudent() {
		
		List<Student> student = repository.findAll();
		return student;
	}

	@Override
	public Student getSingleStudent(String data) {
		
		try {
			try {
				
				Long id =(long) Integer.parseInt(data);
				Student student = repository.findById(id).get();
				return student;

				
			}catch (Exception e) {
				
				Student info = dataFinder(data);
				return info;
				
			}
		}catch(Exception e) {
			
			throw new UserNotFoundException("User not Found!!");
			
		}
		
	}

	@Override
	public Student updateStudent(String data, Student student) {
		
		Student student1;
		
		try {
			try {
				
				Long id =(long) Integer.parseInt(data);
				student1 = repository.findById(id).get();

				
			}catch (Exception e) {
				
				student1 = dataFinder(data);
				
				
			}
		}catch(Exception e) {
			
			throw new UserNotFoundException("User not Found!!");
			
		}
		
		if(student.getName()==null) {
			student.setName(student1.getName());
		}
		if(student.getEmail()==null) {
			student.setName(student1.getEmail());
		}
		if(student.getMobileno()==null) {
			student.setName(student1.getMobileno());
		}
		student.setRollno(student1.getRollno());
		repository.save(student);

		return student;
	}

//	@Override
//	public int deleteStudent(String data) {
//		
//Student student1;
//		
//		try {
//			try {
//				
//				Long id =(long) Integer.parseInt(data);
//				student1 = repository.findById(id).get();
//
//				
//			}catch (Exception e) {
//				
//				student1 = dataFinder(data);
//				
//				
//			}
//		}catch(Exception e) {
//			
//			throw new UserNotFoundException("User not Found!!");
//			
//		}
//		try{
//			repository.delete(student1);
//		}catch (Exception e) {
//			throw new DeleteException();
//		}
//
//		
//		return 1;
//	}
	
	public Student dataFinder(String data) {
		
		Student student = repository.findByName(data);
		if(student!=null) {
			return student;
		} 
		
		student = repository.findByEmail(data);
		if(student!=null) {
			return student;
		} 
		
		student = repository.findByMobileno(data);
		if(student!=null) {
			return student;
		} 
		
		
		throw new UserNotFoundException("User Not Found");
		
	}
	
	@Override
	public int deleteStudent(int data) {
		repository.deleteById((long) data);
		return data;
	}
	
	

}
