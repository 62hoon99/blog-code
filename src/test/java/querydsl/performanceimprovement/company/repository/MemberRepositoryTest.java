package querydsl.performanceimprovement.company.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import querydsl.performanceimprovement.company.entity.Member;

@SpringBootTest
@Transactional
@Rollback
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 엔티티_조회() {
        //given
        Member findMember = memberRepository.findById(1L);
        //then
        Assertions.assertThat(findMember.getName()).isEqualTo("name1");
    }
}