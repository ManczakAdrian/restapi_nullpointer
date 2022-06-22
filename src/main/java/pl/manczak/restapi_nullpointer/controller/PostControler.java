package pl.manczak.restapi_nullpointer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.manczak.restapi_nullpointer.controller.dto.PostDto;
import pl.manczak.restapi_nullpointer.model.Post;
import pl.manczak.restapi_nullpointer.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostControler {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam (required = false)Integer page, Sort.Direction sort){
        int pageNumber= page != null && page>=0 ? page:0;
        Sort.Direction sortDirection=sort !=null ? sort: Sort.Direction.ASC;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber,sortDirection));

    }
    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComment(@RequestParam (required = false)Integer page,Sort.Direction sort){
        int pageNumber= page != null && page>=0 ? page:0;
        Sort.Direction sortDirection=sort !=null ? sort: Sort.Direction.ASC;
        return postService.getPostsWithComments(pageNumber, sortDirection);

    }

    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id) {
        return postService.getSinglePost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);

    }
    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post){
        return postService.editPost(post);

    }
}
