package com.example.StudentDetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.StudentDetails.Dao.StudentDao;
import com.example.StudentDetails.Entity.Student;
import com.example.StudentDetails.Exception.AgeNotEligibleException;

@Service
public class StudentService {
	@Autowired
	StudentDao sd;
	public String insertStud(Student s)throws AgeNotEligibleException {
		if(s.getAge()<18) {
			throw new AgeNotEligibleException("MUST BE ABOVE 18Years");
		}
		else {
			return sd.insertStud(s);
		}
	}
	public int getAttendence(@PathVariable int rollNumber) {
		return sd.getAttendence(rollNumber);
	}
	public ResponseEntity<String> insertAll(@RequestBody List<Student> s)throws AgeNotEligibleException {
		for(Student st:s) {
			if(st.getAge()<18) {
			    throw new AgeNotEligibleException("MUST BE ABOVE 18Yrs");	
			}
		}
		return sd.insertAll(s);
	}
}
