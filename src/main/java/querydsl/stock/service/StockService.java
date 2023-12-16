package querydsl.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydsl.stock.domain.Stock;
import querydsl.stock.repository.StockRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // Stock 조회
        // 재고를 감소시킨다
        // 갱신된 값을 저장하도록 한다.

        Stock stock = stockRepository.findByProductId(id).orElseThrow();
        stock.decrease(quantity);
//        stockRepository.saveAllAndFlush(List.of(stock));
    }
}
