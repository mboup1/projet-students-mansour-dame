package com.mansourdame.student.controller;

import com.mansourdame.student.dto.StudentDTO;
import com.mansourdame.student.entity.Post;
import com.mansourdame.student.entity.Student;
import com.mansourdame.student.service.PostApiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostApiController {

    private final PostApiService postApiService;
    @GetMapping()
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postApiService.getPosts());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postApiService.getPostById(id));
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
