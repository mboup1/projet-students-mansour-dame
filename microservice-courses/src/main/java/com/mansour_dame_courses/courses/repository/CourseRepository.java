package com.mansour_dame_courses.courses.repository;


import com.mansour_dame_courses.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    Optional<Student> findStudentByEmail(String email);
}
