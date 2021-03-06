package pl.manczak.restapi_nullpointer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.manczak.restapi_nullpointer.model.Comment;
import pl.manczak.restapi_nullpointer.model.Post;
import pl.manczak.restapi_nullpointer.repository.PostRepository.CommentRepository;
import pl.manczak.restapi_nullpointer.repository.PostRepository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE=20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    public List<Post> getPosts(int page){
        return postRepository.findAllPosts(PageRequest.of(page,PAGE_SIZE));

    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostsWithComments(int page) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));

        List<Long> ids=allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments,post.getId())));
        return allPosts;

    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId()==id)
                .collect(Collectors.toList());
    }
}
