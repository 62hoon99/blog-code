package querydsl.performanceimprovement.company.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import querydsl.performanceimprovement.company.entity.Member;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberDataRepository memberDataRepository;

    @Test
    public void 엔티티_조회() {
        //given
        Member findMember = memberRepository.findById(1L);
        //then
        Assertions.assertThat(findMember.getName()).isEqualTo("name1");
    }

    @Test
    public void exist_메서드_사용() {
        //given
        memberRepository.goodExistsQuery();
    }

    @Test
    public void cross_join_회피() {
        //given
        List<Member> team = memberRepository.notCrossJoin("name12");
        System.out.println("------------team.size() : " + team.size() + " -----------");
    }
}