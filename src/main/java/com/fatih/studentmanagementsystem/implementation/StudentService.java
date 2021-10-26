package com.fatih.studentmanagementsystem.implementation;

import com.fatih.studentmanagementsystem.entity.Student;
import com.fatih.studentmanagementsystem.repository.IStudentRepository;
import com.fatih.studentmanagementsystem.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private IStudentRepository repository;


    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }
}
