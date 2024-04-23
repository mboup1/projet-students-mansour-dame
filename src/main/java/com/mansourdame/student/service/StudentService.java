package com.mansourdame.student.service;

import com.mansourdame.student.Student;
import com.mansourdame.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return   studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return   studentRepository.findById(id).get();
    }

    public Student addStudent(Student student){
        return   studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student, Long id) {

        Optional<Student> existingStudent = studentRepository.findById(id);

        if (!existingStudent.isPresent()) {
            throw new RuntimeException();

        }

        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        return studentRepository.save(newStudent);

//       return Student.builder()
//               .id(student.getId())
//               .firstName(student.getFirstName())
//               .lastName(student.getLastName())
//               .email(student.getEmail())
//               .build();
    }
}
