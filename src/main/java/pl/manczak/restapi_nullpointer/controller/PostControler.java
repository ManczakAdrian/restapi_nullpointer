package pl.manczak.restapi_nullpointer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.manczak.restapi_nullpointer.controller.dto.PostDto;
import pl.manczak.restapi_nullpointer.model.Post;
import pl.manczak.restapi_nullpointer.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostControler {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam (required = false)int page){
        int pageNumber=page>=0 ? page:0;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber));

    }
    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComment(@RequestParam (required = false)int page,Sort.Direction sort){
        int pageNumber=page>=0 ? page:0;
        return postService.getPostsWithComments(pageNumber);

    }


    @GetMapping("/posts/{id}")
    public Post getSinglePosts(@PathVariable long id) {
        return postService.getSinglePost(id);
    }
}
