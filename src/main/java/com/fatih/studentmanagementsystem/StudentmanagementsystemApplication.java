package com.fatih.studentmanagementsystem;

import com.fatih.studentmanagementsystem.entity.Student;
import com.fatih.studentmanagementsystem.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentmanagementsystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementsystemApplication.class, args);
	}

	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student james = new Student("James", "Lennon", "fatih@mail.com");
//		studentRepository.save(james);
//
//		Student thomas = new Student("Thomas", "Bon", "thomas@mail.com");
//		studentRepository.save(thomas);
	}
}
