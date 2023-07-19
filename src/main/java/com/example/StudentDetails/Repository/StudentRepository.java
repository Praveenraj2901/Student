package com.example.StudentDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.StudentDetails.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value="select attendence from student where roll_number=?",nativeQuery = true)
	public int getAttendence(int rollNumber);
}
