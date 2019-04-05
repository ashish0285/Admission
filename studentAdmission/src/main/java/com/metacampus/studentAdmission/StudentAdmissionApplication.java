package com.metacampus.studentAdmission;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.metacampus.studentAdmission.config.SecurityUtility;
import com.metacampus.studentAdmission.entities.Student;
import com.metacampus.studentAdmission.services.StudentService;
import com.metacampus.studentAdmission.services.UserService;

@SpringBootApplication
public class StudentAdmissionApplication implements CommandLineRunner{

	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentAdmissionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
		// TODO Auto-generated method stub
		Student student1=new Student();
		student1.setName("Test1");
		student1.setEmail("test1@test.com");
		student1.setLoginid("test1");
		student1.setPassword(SecurityUtility.passwordEncoder().encode("1234"));
		student1.setMobilenumber("9772200455");
		student1.setAdmissiondate(LocalDate.parse("01-07-2018", formatter));
		student1.setAdmissionyear(2018);
		student1.setFathername("TestFather1");
		student1.setMothername("TestMother1");
		student1.setJsondata("JSON Data");
		studentService.createStudent(student1);
		
		student1=new Student();
		student1.setName("Test2");
		student1.setEmail("test2@test.com");
		student1.setLoginid("test2");
		student1.setPassword(SecurityUtility.passwordEncoder().encode("1234"));
		student1.setMobilenumber("9772200455");
		student1.setAdmissiondate(LocalDate.parse("05-02-2011", formatter));
		student1.setAdmissionyear(2019);
		student1.setFathername("TestFather2");
		student1.setMothername("TestMother2");
		student1.setJsondata("JSON Data");
		studentService.createStudent(student1);
	}

}
