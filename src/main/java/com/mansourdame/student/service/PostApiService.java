package com.mansourdame.student.service;

import com.mansourdame.student.Exception.StudentEntityNotNullException;
import com.mansourdame.student.Exception.StudentNotFoundException;
import com.mansourdame.student.dto.StudentDTO;
import com.mansourdame.student.dto.StudentMapper;
import com.mansourdame.student.entity.Post;
import com.mansourdame.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostApiService {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private RestClient restClient = RestClient.builder().baseUrl(BASE_URL).build();

    public List<Post> getPosts() {
        return restClient.get().uri("/posts").retrieve().body(new ParameterizedTypeReference<List<Post>>(){});

    }

    public Post getPostById(Integer id) {
        return restClient.get().uri("/posts/"+id).retrieve().body(Post.class);
    }

    public Post addPost(Post newPost) {
        return restClient.post().uri("/posts").contentType(MediaType.APPLICATION_JSON).body(newPost).retrieve().body(Post.class);
    }

    public Post updatePost(Post updatePost, Integer id) {
        return restClient.put().uri("/posts/{id}", id).contentType(MediaType.APPLICATION_JSON).body(updatePost).retrieve().body(Post.class);
    }

    public void deletePostById(Integer id) {
        restClient.delete().uri("/posts/{id}", id).retrieve().toBodilessEntity();
    }




}
