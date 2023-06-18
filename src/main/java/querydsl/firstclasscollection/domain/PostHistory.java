package querydsl.firstclasscollection.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "post_history")
public class PostHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    private Post post;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
