package querydsl.firstclasscollection.domain;

public class PostModifiedEvent {
    private final Post post;

    public PostModifiedEvent(Post post) {
        this.post = post;
    }

    public Long getPostId() {
        return post.getId();
    }

    public String getPostContent() {
        return post.getContent();
    }

    public String getPostTitle() {
        return post.getTitle();
    }
}
