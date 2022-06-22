package pl.manczak.restapi_nullpointer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
    private LocalDateTime created;

    @OneToMany
    @JoinColumn (name="postId",updatable = false, insertable = false)
    private List<Comment> comment;




}
