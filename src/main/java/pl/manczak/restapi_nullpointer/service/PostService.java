package pl.manczak.restapi_nullpointer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.manczak.restapi_nullpointer.model.Post;
import pl.manczak.restapi_nullpointer.repository.PostRepository.PostRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
