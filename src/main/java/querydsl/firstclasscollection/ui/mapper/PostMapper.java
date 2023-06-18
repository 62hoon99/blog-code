package querydsl.firstclasscollection.ui.mapper;

import org.springframework.stereotype.Component;
import querydsl.firstclasscollection.domain.Post;
import querydsl.firstclasscollection.ui.dto.PostRequest;

@Component
public class PostMapper {

    public Post mapFrom(PostRequest request) {
        return new Post(request.getTitle(), request.getContent());
    }
}
