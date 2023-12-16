package querydsl.stock.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import querydsl.stock.service.OptimisticLockStockService;

@Component
@Slf4j
@RequiredArgsConstructor
public class OptimisticLockStockFacade {

    private final OptimisticLockStockService optimisticLockStockService;

    public void decrease(Long id, Long quantity) {

        while (true) {
            try {
                optimisticLockStockService.decrease(id, quantity);

                break;
            } catch (Exception e) {
                log.info("crash");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    log.info("InterruptedException occurs");
                }
            }
        }
    }
}
