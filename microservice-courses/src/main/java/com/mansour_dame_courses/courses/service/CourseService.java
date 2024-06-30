package com.mansour_dame_courses.courses.service;

import com.mansour_dame_courses.courses.Exception.CourseException;
import com.mansour_dame_courses.courses.entity.Course;
import com.mansour_dame_courses.courses.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (!existingCourse.isPresent()) {
            throw new CourseException.CourseNotFoundException("No course found with this ID : " + id);
        }
        return existingCourse.get();
    }

    public ResponseEntity<?> addCourse(Course newCourse) {
        if (newCourse.getName() == null || newCourse.getName().isBlank()) {
            throw new CourseException.CourseFieldsMissingException("Course name must be provided");
        }
        Course savedCourse = courseRepository.save(newCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

//    public ResponseEntity<?> addCourseToStudent(Course newCourse) {
//
//        System.out.println("newCourse.getStudent() :"+ newCourse.getIdStudent());
//
//        Optional<Student> existingStudent = studentRepository.findById(newCourse.getIdStudent());
//
//        if (!existingStudent.isPresent()) {
//            throw new StudentNotFoundException("No student found with this ID : " + newCourse.getIdStudent());
//
//        }
//
//        newCourse.setStudent(existingStudent.get());
//
//        if (newCourse.getName() == null || newCourse.getName().isBlank()) {
//            throw new CourseException.CourseFieldsMissingException("Course name must be provided");
//        }
//        Course savedCourse = courseRepository.save(newCourse);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
//    }
//
//    public ResponseEntity<?> updateCourse(Course updateCourse, Long id) {
//        if (updateCourse.getName() == null || updateCourse.getName().isBlank()) {
//            throw new CourseException.CourseFieldsMissingException("Course name must be provided");
//        }
//        Optional<Course> existingCourse = courseRepository.findById(id);
//        if (!existingCourse.isPresent()) {
//            throw new CourseException.CourseNotFoundException("No course found with this ID : " + id);
//        }
//        Course newCourse = new Course();
//        newCourse.setId(updateCourse.getId());
//        newCourse.setName(updateCourse.getName());
//        Course updatedCourse = courseRepository.save(newCourse);
//        return ResponseEntity.status(HttpStatus.CREATED).body(updatedCourse);
//    }
//
//    public void deleteCourseById(Long id) {
//        Optional<Course> existingCourse = courseRepository.findById(id);
//        if (!existingCourse.isPresent()) {
//            throw new CourseException.CourseNotFoundException("No course found with this ID : " + id);
//        }
//        courseRepository.deleteById(id);
//    }
}
