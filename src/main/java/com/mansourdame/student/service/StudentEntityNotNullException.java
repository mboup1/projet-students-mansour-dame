package com.mansourdame.student.service;

public class StudentEntityNotNullException extends RuntimeException {
    public StudentEntityNotNullException(String message) {
        super(message);
    }
}
