package querydsl.firstclasscollection.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydsl.firstclasscollection.domain.Post;
import querydsl.firstclasscollection.domain.PostRepository;
import querydsl.firstclasscollection.domain.Tag;
import querydsl.firstclasscollection.dto.PostDetailsResponse;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDetailsResponse getPostDetails(Long postId) {
        Post findPost = getPostByIdWithTags(postId);
        String joinedTitles = getJoinedTitles(findPost.getTags());
        return PostDetailsResponse.from(findPost, joinedTitles);
    }

    private String getJoinedTitles(List<Tag> tags) {
        List<String> titles = tags.stream()
                .map(Tag::getTitle)
                .collect(Collectors.toList());
        return String.join(",", titles);
    }

    private Post getPostByIdWithTags(Long postId) {
        return postRepository.fetchFindById(postId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
