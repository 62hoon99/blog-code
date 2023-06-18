package querydsl.firstclasscollection.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import querydsl.firstclasscollection.domain.Post;
import querydsl.firstclasscollection.service.PostService;
import querydsl.firstclasscollection.ui.dto.PostRequest;
import querydsl.firstclasscollection.ui.mapper.PostMapper;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostMapper postMapper;
    private final PostService postService;

    @PutMapping("/post/{postId}")
    public ResponseEntity<Post> modifyPost(@PathVariable(value = "postId") Long postId,
                                           @RequestBody PostRequest request) {

        return ResponseEntity.ok(postService.modify(postId, postMapper.mapFrom(request)));
    }
}
