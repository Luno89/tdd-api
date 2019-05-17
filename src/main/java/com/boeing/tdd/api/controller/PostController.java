package com.boeing.tdd.api.controller;

import com.boeing.tdd.api.entity.Post;
import com.boeing.tdd.api.repository.PostRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    PostRepository postRepository;

    PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/posts")
    public List<Post> posts() {
        return postRepository.findAll();
    }

    @RequestMapping("/post")
    public void post(Post post) {
        postRepository.save(post);
    }
}
