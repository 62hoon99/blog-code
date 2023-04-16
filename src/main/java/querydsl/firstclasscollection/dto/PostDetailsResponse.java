package querydsl.firstclasscollection.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import querydsl.firstclasscollection.domain.Post;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class PostDetailsResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String tags;

    public static PostDetailsResponse from(Post post, String tags) {
        return PostDetailsResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .tags(tags)
                .build();
    }
}
