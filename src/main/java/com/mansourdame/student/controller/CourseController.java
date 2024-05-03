package com.mansourdame.student.controller;

import com.mansourdame.student.entity.Course;
import com.mansourdame.student.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping()
    public ResponseEntity<?> addCourse(@RequestBody Course newCourse) {
        return courseService.addCourse(newCourse);
    }

    @PostMapping("/{add-course}")
    public ResponseEntity<?> addCourseToStudent(@RequestBody Course newCourse) {
        return courseService.addCourseToStudent(newCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        return courseService.updateCourse(course, id);
    }
}
