package querydsl.performanceimprovement.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import querydsl.performanceimprovement.company.entity.Member;

public interface MemberDataRepository extends JpaRepository<Member, Long> {
}
