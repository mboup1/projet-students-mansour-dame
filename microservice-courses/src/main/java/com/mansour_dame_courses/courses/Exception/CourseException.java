package com.mansour_dame_courses.courses.Exception;

public class CourseException extends RuntimeException {
    public CourseException(String message) {
        super(message);
    }

    public static class CourseNotFoundException extends CourseException {
        public CourseNotFoundException(String message) {
            super(message);
        }
    }

    public static class CourseFieldsMissingException extends CourseException {
        public CourseFieldsMissingException(String message) {
            super(message);
        }
    }
}
