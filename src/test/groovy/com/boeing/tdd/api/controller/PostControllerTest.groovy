package com.boeing.tdd.api.controller

import com.boeing.tdd.api.entity.Post
import com.boeing.tdd.api.repository.PostRepository
import spock.lang.Specification

class PostControllerTest extends Specification {

    PostController controller
    PostRepository postRepository

    def setup() {
        postRepository = Mock(PostRepository)
        postRepository.findAll() >> [new Post()]
        controller = new PostController(postRepository)
    }

    def "returns a list of posts" () {
        when:
        List<Post> posts = controller.posts()

        then:
        posts != null
    }

    def "uses the PostRepository to get Posts" () {
        when:
        List<Post> posts = controller.posts()

        then:
        posts.size() == 1
    }

    def "saves the post" () {
        given:
        Post post = new Post(name: "jim", last:"bob")

        when:
        controller.post(post);

        then:
        1 * postRepository.save(post)
    }
}
