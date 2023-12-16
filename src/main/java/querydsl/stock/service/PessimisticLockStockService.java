package querydsl.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydsl.stock.domain.Stock;
import querydsl.stock.repository.StockRepository;

@Service
@RequiredArgsConstructor
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {

        Stock stock = stockRepository.findByProductIdWithPessimisticLock(id).orElseThrow();

        stock.decrease(quantity);
    }}
