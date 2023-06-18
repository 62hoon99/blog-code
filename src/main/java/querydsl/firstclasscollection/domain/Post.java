package querydsl.firstclasscollection.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Arrays;

@Getter
@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends AbstractAggregateRoot<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @Embedded
    private Tags tags = new Tags();

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addTag(Tag... tag) {
        tags.addAll(Arrays.asList(tag));
    }

    public void modify(Post request) {
        this.title = request.title;
        this.content = request.content;
        registerEvent(new PostModifiedEvent(this));
    }
}
