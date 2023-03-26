package querydsl.performanceimprovement.company.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import querydsl.performanceimprovement.company.entity.Member;

import static querydsl.performanceimprovement.company.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final JPAQueryFactory queryFactory;

    public Member findById(long memberId) {
        return queryFactory
                .selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchFirst();
    }
}
