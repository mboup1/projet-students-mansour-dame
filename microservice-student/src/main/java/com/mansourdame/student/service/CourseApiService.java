package com.mansourdame.student.service;

import com.mansourdame.student.dto.CourseDTO;
import com.mansourdame.student.entity.Student;
import com.mansourdame.student.dto.StudentCourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseApiService {
    public static final String BASE_URL = "http://localhost:8081/";

    private RestClient restClient = RestClient.builder().baseUrl(BASE_URL).build();

    @Autowired
    StudentService studentService;


    public StudentCourseDTO getCoursesToStudent(Long id) {
        List<CourseDTO> coursesDTO = restClient.get().uri("api/v1/courses").retrieve().body(new ParameterizedTypeReference<List<CourseDTO>>() {
        });

        Student student = studentService.getStudentById(id);

        return StudentCourseDTO.builder()
//                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .courses(coursesDTO)
                .build();

    }

//    public Post getPostById(Integer id) {
//        return restClient.get().uri("/posts/"+id).retrieve().body(Post.class);
//    }
//
//    public Post addPost(Post newPost) {
//        return restClient.post().uri("/posts").contentType(MediaType.APPLICATION_JSON).body(newPost).retrieve().body(Post.class);
//    }
//
//    public Post updatePost(Post updatePost, Integer id) {
//        return restClient.put().uri("/posts/{id}", id).contentType(MediaType.APPLICATION_JSON).body(updatePost).retrieve().body(Post.class);
//    }
//
//    public void deletePostById(Integer id) {
//        restClient.delete().uri("/posts/{id}", id).retrieve().toBodilessEntity();
//    }




}
