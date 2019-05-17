package com.boeing.tdd.api.repository;

import com.boeing.tdd.api.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
