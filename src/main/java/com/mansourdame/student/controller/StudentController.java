package com.mansourdame.student.controller;

import com.mansourdame.student.Student;
import com.mansourdame.student.repository.StudentRepository;
import com.mansourdame.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;



    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getAllStudents() ;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return   studentService.getStudentById(id);
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student){
        return  studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return  studentService.updateStudent(student, id);
    }

}
