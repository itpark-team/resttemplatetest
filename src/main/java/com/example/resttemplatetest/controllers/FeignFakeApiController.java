package com.example.resttemplatetest.controllers;

import com.example.resttemplatetest.ApiRepository.FakeApiRepository;
import com.example.resttemplatetest.models.Post;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feign-fake")
@AllArgsConstructor
public class FeignFakeApiController {

    private FakeApiRepository fakeApiRepository;

    @GetMapping("/get-post-by-id/{id}")
    public Post getPost(@PathVariable int id) {
        Post post = fakeApiRepository.getPostById(id);
        return post;
    }

    @GetMapping("/get-all-posts")
    public List<Post> getAllPosts() {
        return fakeApiRepository.getPosts();
    }
}
