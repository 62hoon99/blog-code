package querydsl.stock.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import querydsl.stock.domain.Stock;
import querydsl.stock.facade.LettuceLockStockFacade;
import querydsl.stock.facade.OptimisticLockStockFacade;
import querydsl.stock.facade.RedissonLockStockFacade;
import querydsl.stock.repository.StockRepository;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private RedissonLockStockFacade stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void before() {
        stockRepository.saveAll(List.of(new Stock(1L, 100L)));
    }

    @AfterEach
    public void after() {
        stockRepository.deleteAll();
    }

    @Test
    public void 동시에_100개의_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    stockService.decrease(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // CountDownLatch는 다른 Thread에서 수행 중인 작업이 완료될 때까지 대기할 수 있도록 도와주는 클래스

        Stock stock = stockRepository.findByProductId(1L).orElseThrow();

        // 100 - (1 * 100) = 0
        assertThat(0L).isEqualTo(stock.getQuantity());

        // 레이스 컨디션: 둘 이상의 Thread가 공유 데이터에 액세스할 수 있고 동시에 변경을 하려고 할 때 발생하는 문제이다.
        // 두 개 이상의 스레드가 공유 데이터에 액세스를 할 수 있고 동시에 변경을 하려고 할 때 발생하는 문제를 레이스 컨디션이라고 한다.
        // 이런 문제를 해결하기 위해서는 우리의 예상대로 하나의 스레드가 작업이 완료된 이후에 다른 스레드가 데이터에 접근할 수 있도록 해야 한다.
    }


}