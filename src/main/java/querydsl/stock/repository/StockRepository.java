package querydsl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import querydsl.stock.domain.Stock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductId(Long productId);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Stock s where s.productId = :productId")
    Optional<Stock> findByProductIdWithPessimisticLock(@Param("productId") Long productId);

    @Lock(value = LockModeType.OPTIMISTIC)
    @Query("select s from Stock s where s.productId = :productId")
    Optional<Stock> findByProductIdWithOptimisticLock(@Param("productId") Long productId);
}
