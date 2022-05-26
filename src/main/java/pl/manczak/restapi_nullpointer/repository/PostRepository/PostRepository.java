package pl.manczak.restapi_nullpointer.repository.PostRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.manczak.restapi_nullpointer.model.Post;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   // List<Post> findAllByTitle(String title);

    @Query("Select p From Post p" )
    List<Post>findAllPosts(Pageable pageable  );


}
