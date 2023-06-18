package querydsl.firstclasscollection.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SavePostHistoryWithPostModifiedEvent {

    private final PostHistoryRepository postHistoryRepository;

    @Async
    @EventListener
    @Transactional
    public void handle(PostModifiedEvent event) {
        PostHistory postHistory = PostHistory.save(event);
        postHistoryRepository.save(postHistory);
    }
}
