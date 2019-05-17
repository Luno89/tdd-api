package com.boeing.tdd.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerIntegrationTest {


    @Autowired
    private WebTestClient webClient;

    @Test
    public void returnsOkStatus() {
        webClient.get().uri("/posts").exchange().expectStatus().isOk();
    }

    @Test
    public void postPostOkStatus() {
        webClient.post().uri("/post").exchange().expectStatus().isOk();
    }

    @Test
    public void returnsHelloWorldFromHello() {
        webClient.get().uri("/hello").accept(MediaType.TEXT_PLAIN).exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello?");
    }
}
