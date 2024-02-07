package com.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Backend.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public Student findByName(String name);
	public Student findByEmail(String email);
	@Query("From Student where mobileno = :mobileno")
	public Student findByMobileno(String mobileno);

}
