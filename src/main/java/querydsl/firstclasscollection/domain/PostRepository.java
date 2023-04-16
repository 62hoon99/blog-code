package querydsl.firstclasscollection.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p left join fetch p.tags where p.id = :postId")
    Optional<Post> fetchFindById(Long postId);
}
