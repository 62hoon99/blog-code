package querydsl.performanceimprovement.company.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import querydsl.performanceimprovement.company.entity.Member;

import java.util.List;

import static querydsl.performanceimprovement.company.entity.QMember.member;
import static querydsl.performanceimprovement.company.entity.QTeam.team;

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

    public boolean goodExistsQuery() {
        Integer fetchOne = queryFactory
                .selectOne()
                .from(member)
                .where(member.id.gt(0L))
                .fetchFirst();

        return fetchOne != null;
    }


    public List<Member> crossJoin(String teamName) {
        return queryFactory
                .selectFrom(member)
                .where(member.team.name.eq(teamName))
                .fetch();
    }


    public List<Member> notCrossJoin(String teamName) {
        return queryFactory
                .select(member)
                .from(member)
                .innerJoin(member.team, team)
                .where(team.name.eq(teamName))
                .fetch();
    }
}
