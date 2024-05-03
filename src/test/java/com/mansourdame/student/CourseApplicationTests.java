package com.mansourdame.student;

import com.mansourdame.student.entity.Course;
import com.mansourdame.student.entity.Student;
import com.mansourdame.student.repository.CourseRepository;
import com.mansourdame.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseApplicationTests {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void AddCoursesToStudent() {
		Student student = new Student();
		student.setLastName("Zuckerberg");
		student.setFirstName("Marc");
		student.setEmail("marc@marc.com");
		studentRepository.save(student);

		Course course1 = new Course();
		course1.setName("Maths");
		course1.setStudent(student);
		courseRepository.save(course1);

		Course course2 = new Course();
		course2.setName("Physique chimie");
		course2.setStudent(student);
		courseRepository.save(course2);
	}

}
