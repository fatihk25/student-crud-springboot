package com.fatih.studentmanagementsystem.controller;

import com.fatih.studentmanagementsystem.entity.Student;
import com.fatih.studentmanagementsystem.implementation.StudentService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        super();
        this.service = service;
    }

    @GetMapping("/students")
    public String listOfStudent(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/students/add")
    public String addNewStudent(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Mode model) {
        Student studentData = service.getStudentById(id);
        studentData.setId(id);
        studentData.setFirstName(student.getFirstName());
        studentData.setLastName(student.getLastName());
        studentData.setEmail(student.getEmail());

        service.updateStudent(studentData);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudentById(id);
        return "redirect:/students";
    }
}
