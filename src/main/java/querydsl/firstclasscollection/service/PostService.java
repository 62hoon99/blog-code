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
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDetailsResponse getPostDetails(Long postId) {
        Post findPost = getPostByIdWithTags(postId);
        return PostDetailsResponse.from(findPost);
    }

    private Post getPostByIdWithTags(Long postId) {
        return postRepository.fetchFindById(postId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Post modify(Long postId, Post request) {
        Post post = postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        post.modify(request);
        return postRepository.save(post);
    }
}
