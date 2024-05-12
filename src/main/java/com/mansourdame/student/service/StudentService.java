package com.mansourdame.student.service;

import com.mansourdame.student.Exception.EmailNotFoundException;
import com.mansourdame.student.Exception.StudentNotFoundException;
import com.mansourdame.student.dto.StudentDTO;
import com.mansourdame.student.dto.StudentMapper;
import com.mansourdame.student.entity.Student;
import com.mansourdame.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
            throw new StudentNotFoundException("No student found with this ID : " + id);
        }
        return existingStudent.get();
    }

    public Student getStudentByEmail(String email) {
        Optional<Student> existingStudentByEmail = studentRepository.findStudentByEmail(email);
        if (!existingStudentByEmail.isPresent()) {
            throw new EmailNotFoundException("No student found with this : " + email);
        }

        return existingStudentByEmail.get();
    }

    public Student addStudent(StudentDTO studentDTO) {

        if (Objects.isNull(studentDTO)) {
            throw new StudentEntityNotNullException("Student data is null");
        }

        Student savedStudent = StudentMapper.convertDtoToEntity(studentDTO);

        studentRepository.save(savedStudent);

        return savedStudent;
    }

    public Student updatedStudent(Student updateStudent, Long id) {

        Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("No student found with this ID : " + id));

        existingStudent.setFirstName(updateStudent.getFirstName());
        existingStudent.setLastName(updateStudent.getLastName());
        existingStudent.setEmail(updateStudent.getEmail());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (!existingStudent.isPresent()) {
            throw new StudentNotFoundException("No student found with this ID : " + id);
        }

        studentRepository.deleteById(id);
    }

}
