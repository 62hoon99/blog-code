package querydsl.firstclasscollection.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TagsTest {

    private Tags tags;
    private String joinedTagTitle;

    @BeforeEach
    public void set() {
        Tag tag1 = new Tag("모니터");
        Tag tag2 = new Tag("27인치 모니터");
        Tag tag3 = new Tag("FHD 모니터");

        this.tags = new Tags();
        tags.addAll(List.of(tag1, tag2, tag3));
        this.joinedTagTitle = tag1.getTitle() + "," + tag2.getTitle() + "," + tag3.getTitle();
    }

    @Test
    public void 상세조회_태그가_하나의_문자열로_반환() throws Exception {
        //then
        assertThat(tags.getJoinedTitles()).isEqualTo(joinedTagTitle);
    }
}