package com.metacampus.studentAdmission.services;

import java.util.List;

import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacampus.studentAdmission.entities.Role;
import com.metacampus.studentAdmission.entities.RoleType;
import com.metacampus.studentAdmission.entities.Student;
import com.metacampus.studentAdmission.entities.User;


@Service
public class StudentService extends UserService{

	
	@Transactional
	public Student createStudent(Student student) {
		if(student==null) return null;
		return (Student)createUser(student,RoleType.STUDENT);
	}
	
	
}