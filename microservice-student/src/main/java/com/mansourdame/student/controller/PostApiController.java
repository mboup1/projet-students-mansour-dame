package com.mansourdame.student.controller;

import com.mansourdame.student.entity.Post;
import com.mansourdame.student.dto.StudentCourseDTO;
import com.mansourdame.student.service.CourseApiService;
import com.mansourdame.student.service.PostApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostApiController {

    private final PostApiService postApiService;

    private final CourseApiService courseApiService;
    @GetMapping()
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postApiService.getPosts());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postApiService.getPostById(id));
    }

    @GetMapping("course-student/{id}")
    public ResponseEntity<StudentCourseDTO> getCoursesToStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(courseApiService.getCoursesToStudent(id));
    }

    @PostMapping()
    public ResponseEntity<Post> addPost(@RequestBody Post newPost) {
        return ResponseEntity.ok(postApiService.addPost(newPost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post newPost, @PathVariable Integer id) {
        return ResponseEntity.ok(postApiService.updatePost(newPost, id));
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Integer id) {
        postApiService.deletePostById(id);
    }
}
