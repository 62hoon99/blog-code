package querydsl.firstclasscollection.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "post_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "posts_id")
    private Long postId;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public PostHistory(Long postId, String title, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static PostHistory save(PostModifiedEvent event) {
        return new PostHistory(event.getPostId(), event.getPostTitle(), event.getPostContent(), LocalDateTime.now());
    }
}
