package pl.manczak.restapi_nullpointer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.manczak.restapi_nullpointer.model.Post;

import java.util.List;

@RestController
public class PostControler {

    @GetMapping("/posts")
    public List<Post> getPosts(){
throw  new IllegalArgumentException("Not implemented yet");

    }
    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id) {
        throw new IllegalArgumentException("Not implemented yet");

    }
}
