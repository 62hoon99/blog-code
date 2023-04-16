package querydsl.firstclasscollection.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import querydsl.firstclasscollection.domain.Post;
import querydsl.firstclasscollection.domain.PostRepository;
import querydsl.firstclasscollection.domain.Tag;
import querydsl.firstclasscollection.dto.PostDetailsResponse;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    private Post post;
    private String joinedTagTitle;

    @BeforeEach
    public void set() {
        Post post = new Post("LG 모니터 27인치 판매합니다.", "사용한지 2년된 멀쩡한 모니터입니다. 연락주세요.");
        Tag tag1 = new Tag(post, "모니터");
        Tag tag2 = new Tag(post, "27인치 모니터");
        Tag tag3 = new Tag(post, "FHD 모니터");
        post.addTag(tag1, tag2, tag3);

        this.post = postRepository.save(post);
        this.joinedTagTitle = tag1.getTitle() + "," + tag2.getTitle() + "," + tag3.getTitle();
    }

    @Test
    public void 상세조회_태그가_하나의_문자열로_반환() throws Exception {
        //given
        PostDetailsResponse postDetails = postService.getPostDetails(post.getId());
        //then
        Assertions.assertThat(postDetails.getTags()).isEqualTo(joinedTagTitle);
    }

}