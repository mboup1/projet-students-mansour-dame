//package com.mansourdame.student.service;
package com.mansourdame.student.service;

import com.mansourdame.student.Exception.EmailNotFoundException;
import com.mansourdame.student.Exception.StudentEntityNotNullException;
import com.mansourdame.student.Exception.StudentNotFoundException;
import com.mansourdame.student.dto.StudentDTO;
import com.mansourdame.student.dto.StudentMapper;
import com.mansourdame.student.entity.Student;
import com.mansourdame.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private  StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    StudentMapper studentMapper;

    @Test
    public void testGetAllStudents(){

        Student student1 = new Student(1L,"bezos", "jeff","jeff@jeff.com");
        Student student2 = new Student(2L,"jobs", "steve","steve@steve.com");
        Student student3 = new Student(3L,"altman", "sam","sam@sam.com");

        List<Student> students = Arrays.asList(student1, student2, student3);
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        studentService.getAllStudents();

        assertEquals(3,studentService.getAllStudents().size());
    }

    @Test
    public void testGetStudentById(){
        Long studentId = 1L;
        Student student1 = new Student(studentId,"bezos", "jeff","jeff@jeff.com");

        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));

        Student foundStudent= studentService.getStudentById(studentId);

        assertEquals(student1.getId(),foundStudent.getId());
        assertEquals(student1.getLastName(),foundStudent.getLastName());
        assertEquals(student1.getFirstName(),foundStudent.getFirstName());
    }

    @Test
    public void testGetStudentWithNullDTO() {

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentById(null);
        });
    }

    @Test
    public void testGetStudentByEmail(){

        Student student1 = new Student(1L,"bezos", "jeff","jeff@jeff.com");

        Mockito.when(studentRepository.findStudentByEmail("jeff@jeff.com")).thenReturn(Optional.of(student1));

        Student foundStudent= studentService.getStudentByEmail("jeff@jeff.com");

        assertEquals(student1.getEmail(),foundStudent.getEmail());
    }

    @Test
    public void testGetStudentByEmailWithNullDTO() {

        assertThrows(EmailNotFoundException.class, () -> {
            studentService.getStudentByEmail(null);
        });
    }


    @Test
    public void testAddStudentById(){
        StudentDTO studentDTO = new StudentDTO("bezos", "jeff","jeff@jeff.com");

        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());

        Mockito.when(studentRepository.save(student)).thenReturn(student);

        Student foundStudent= studentService.addStudent(studentDTO);

        assertEquals(studentDTO.getLastName(),foundStudent.getLastName());
        assertEquals(studentDTO.getFirstName(),foundStudent.getFirstName());
    }

    @Test
    public void testAddStudentWithNullDTO() {
        StudentDTO studentDTO = null;

        assertThrows(StudentEntityNotNullException.class, () -> {
            studentService.addStudent(studentDTO);
        });
    }

    @Test
    public void testDeleteStudentById() {
        Long studentId = 1L;
        Student student1 = new Student(studentId,"bezos", "jeff","jeff@jeff.com");

        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student1));

        studentService.deleteStudentById(studentId);

        verify(studentRepository, times(1)).deleteById(studentId);

    }

    @Test
    public void testDeleteStudentWithNullDTO() {

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.deleteStudentById(null);
        });
    }

    @Test
    public void testUpdateStudentById(){
        Student student = new Student(1L,"bezos", "jeff","jeff@jeff.com");
        Long id = 1L;

        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Mockito.when(studentRepository.save(student)).thenReturn(student);

        Student studentUpdated =studentService.updatedStudent(student,id);

        assertEquals(student.getFirstName(), studentUpdated.getFirstName() );
    }

}