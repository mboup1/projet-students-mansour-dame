package com.mansourdame.student.Exception;

public class StudentException extends RuntimeException {
    public StudentException(String message) {
        super(message);
    }

    public static class StudentNotFoundException extends StudentException {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }

    public static class EmailNotFoundException extends StudentException {
        public EmailNotFoundException(String message) {
            super(message);
        }
    }

    public static class StudentFieldsMissingException extends StudentException {
        public StudentFieldsMissingException(String message) {
            super(message);
        }
    }

    public static class InvalidEmailFormatException extends StudentException {
        public InvalidEmailFormatException(String message) {
            super(message);
        }
    }
}
