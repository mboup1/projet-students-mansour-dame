package com.mansourdame.student.dto;

import com.mansourdame.student.dto.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentCourseDTO {
//    private long id;

    private String firstName;
    private String lastName;
    private String email;

    private List<CourseDTO> courses;
}
