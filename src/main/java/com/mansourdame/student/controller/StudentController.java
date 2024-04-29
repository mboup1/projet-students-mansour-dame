package com.mansourdame.student.controller;

import com.mansourdame.student.Exception.StudentNotFoundException;
import com.mansourdame.student.entity.Student;
import com.mansourdame.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getAllStudents() ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return   ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email){
        return   ResponseEntity.ok(studentService.getStudentByEmail(email));
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
