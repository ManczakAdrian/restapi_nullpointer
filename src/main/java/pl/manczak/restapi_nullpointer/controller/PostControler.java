package pl.manczak.restapi_nullpointer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.manczak.restapi_nullpointer.model.Post;
import pl.manczak.restapi_nullpointer.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostControler {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.getPosts();

    }
    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id) {
        return postService.getSinglePost(id);
    }
}
