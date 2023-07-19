package com.example.StudentDetails.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.StudentDetails.Entity.Student;
import com.example.StudentDetails.Exception.AgeNotEligibleException;
import com.example.StudentDetails.Repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository sr;
	public String insertStud(Student s) {
		sr.save(s);
		return "SUCCESS";
	}
	public int getAttendence(@PathVariable int rollNumber) {
		return sr.getAttendence(rollNumber);
	}
	public ResponseEntity<String> insertAll(@RequestBody List<Student> s)throws AgeNotEligibleException {
		sr.saveAll(s);
		return ResponseEntity.ok("SUCCESS");
	}

}
