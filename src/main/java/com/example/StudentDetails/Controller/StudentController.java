package com.example.StudentDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentDetails.Entity.Student;
import com.example.StudentDetails.Exception.AgeNotEligibleException;
import com.example.StudentDetails.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	@PostMapping(value="/insertStud") 
	public String insertStud(@RequestBody Student s)throws AgeNotEligibleException {
		return ss.insertStud(s);
	}
	@GetMapping(value="/getAttendence/{rollNumber}")
	public int getAttendence(@PathVariable int rollNumber) {
		return ss.getAttendence(rollNumber);
	}
	@PostMapping(value="/insertAll")
	public ResponseEntity<String> insertAll(@RequestBody List<Student> s)throws AgeNotEligibleException {
		return ss.insertAll(s);
	}
	

}
