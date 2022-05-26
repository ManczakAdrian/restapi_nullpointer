package pl.manczak.restapi_nullpointer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.manczak.restapi_nullpointer.model.Post;
import pl.manczak.restapi_nullpointer.repository.PostRepository.PostRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE=20;
    private final PostRepository postRepository;


    public List<Post> getPosts(int page){
        return postRepository.findAllPosts(PageRequest.of(page,PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
