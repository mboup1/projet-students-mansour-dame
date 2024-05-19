package com.mansourdame.student.controller.handler;

import com.mansourdame.student.Exception.CourseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseControllerAdvice {

    @ExceptionHandler(CourseException.CourseNotFoundException.class)
    public ResponseEntity<?> handleCourseNotFoundException(CourseException.CourseNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CourseException.CourseFieldsMissingException.class)
    public ResponseEntity<?> handleCourseFieldsMissingException(CourseException.CourseFieldsMissingException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
