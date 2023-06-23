package com.example.resttemplatetest.controllers;

import com.example.resttemplatetest.models.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("fake")
@AllArgsConstructor
public class FakeApiController {

    private RestTemplate restTemplate;

    @GetMapping("/get-post-by-id/{id}")
    public Post getPost(@PathVariable int id) {

        String url = String.format("https://jsonplaceholder.typicode.com/posts/%s", id);

        Post post = restTemplate.getForObject(url, Post.class);

        return post;

//        ResponseEntity<Post> postResponseEntity = null;
//        try {
//            postResponseEntity = restTemplate.getForEntity(url, Post.class);
//
//            if (postResponseEntity.getStatusCode() != HttpStatusCode.valueOf(200)) {
//                return Post.builder()
//                        .id(0)
//                        .body("unknown")
//                        .title("unknown")
//                        .userId(0)
//                        .build();
//            }
//        }
//        catch (Exception e){
//
//            int a=5;
//        }
//
//         return Post.builder()
//                .id(0)
//                .body("unknown")
//                .title("unknown")
//                .userId(0)
//                .build();
    }

    @GetMapping("/get-all-posts")
    public List<Post> getAllPosts() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        Post[] tempPosts = restTemplate.getForObject(url, Post[].class);
        List<Post> posts = Arrays.asList(tempPosts);

        return posts;
    }

    @PostMapping("/add-new")
    public Post addNew(@RequestBody Post post) {

        Post responsePost = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", post, Post.class);

        return responsePost;
    }

    @PostMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable int id) {

        String url = String.format("https://jsonplaceholder.typicode.com/posts/%s", id);

        restTemplate.delete(url);
    }

    @PutMapping("/update-by-id/{id}")
    public void deleteById(@PathVariable int id, @RequestBody Post post) {

        String url = String.format("https://jsonplaceholder.typicode.com/posts/%s", id);

        restTemplate.put(url, post);
    }

    @PutMapping("/update-by-id2/{id}")
    public Post deleteById2(@PathVariable int id, @RequestBody Post post) {

        String url = String.format("https://jsonplaceholder.typicode.com/posts/%s", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Post> httpEntity = new HttpEntity<>(post, headers);

        ResponseEntity<Post> postResponse = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Post.class);

        return postResponse.getBody();
    }
}
