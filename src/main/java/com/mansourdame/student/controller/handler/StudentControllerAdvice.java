package com.mansourdame.student.controller.handler;

import com.mansourdame.student.Exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerAdvice {

    @ExceptionHandler(StudentException.StudentNotFoundException.class)
    public ResponseEntity<?> handleStudentNotFoundException(StudentException.StudentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(StudentException.EmailNotFoundException.class)
    public ResponseEntity<?> handleEmailNotFoundException(StudentException.EmailNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(StudentException.StudentFieldsMissingException.class)
    public ResponseEntity<?> handleAddStudentException(StudentException.StudentFieldsMissingException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(StudentException.InvalidEmailFormatException.class)
    public ResponseEntity<?> handleInvalidEmailFormatException(StudentException.InvalidEmailFormatException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
