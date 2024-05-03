package com.mansourdame.student.service;

import com.mansourdame.student.entity.Student;
import com.mansourdame.student.Exception.StudentException;
import com.mansourdame.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {

        Optional<Student> existingStudent = studentRepository.findById(id);
        if (!existingStudent.isPresent()) {
            throw new StudentException.StudentNotFoundException("No student found with this ID : " + id);
        }
        return existingStudent.get();
    }

    public Student getStudentByEmail(String email) {
        Optional<Student> existingStudentByEmail = studentRepository.findStudentByEmail(email);
        if (!existingStudentByEmail.isPresent()) {
            throw new StudentException.EmailNotFoundException("No student found with this : " + email);
        }

        return existingStudentByEmail.get();
    }

    public ResponseEntity<?> addStudent(Student newStudent) {

        if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank() ||
                newStudent.getLastName() == null || newStudent.getLastName().isBlank() ||
                newStudent.getEmail() == null || newStudent.getEmail().isBlank()) {
            throw new StudentException.StudentFieldsMissingException("All fields must be completed");
        }

        if (!newStudent.getEmail().contains("@")) {
            throw new StudentException.InvalidEmailFormatException("Invalid email format");
        }

        Student savedStudent = studentRepository.save(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    public ResponseEntity<?> updatedStudent(Student updateStudent, Long id) {

        if (updateStudent.getFirstName() == null || updateStudent.getFirstName().isBlank() ||
                updateStudent.getLastName() == null || updateStudent.getLastName().isBlank() ||
                updateStudent.getEmail() == null || updateStudent.getEmail().isBlank()) {
            throw new StudentException.StudentFieldsMissingException("All fields must be completed");
        }

        Optional<Student> existingStudent = studentRepository.findById(id);

        if (!existingStudent.isPresent()) {
            throw new StudentException.StudentNotFoundException("No student found with this ID : " + id);

        }

        Student newStudent = new Student();
        newStudent.setId(updateStudent.getId());
        newStudent.setFirstName(updateStudent.getFirstName());
        newStudent.setLastName(updateStudent.getLastName());
        newStudent.setEmail(updateStudent.getEmail());

        Student updatedStudent = studentRepository.save(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedStudent);
    }

    public void deleteStudentById(Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (!existingStudent.isPresent()) {
            throw new StudentException.StudentNotFoundException("No student found with this ID : " + id);
        }

        studentRepository.deleteById(id);
    }

}
