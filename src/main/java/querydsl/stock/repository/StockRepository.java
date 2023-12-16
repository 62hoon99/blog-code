package querydsl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import querydsl.stock.domain.Stock;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductId(Long productId);
}
