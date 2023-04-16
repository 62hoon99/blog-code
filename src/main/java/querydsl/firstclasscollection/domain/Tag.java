package querydsl.firstclasscollection.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    private Post post;

    @Column(length = 10, nullable = false)
    private String title;

    public Tag(Post post, String title) {
        this.post = post;
        this.title = title;
    }

    public Tag(String title) {
        this.title = title;
    }
}
