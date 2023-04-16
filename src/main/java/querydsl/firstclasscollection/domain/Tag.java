package querydsl.firstclasscollection.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(length = 10, nullable = false)
    private String title;
}
