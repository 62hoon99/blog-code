package querydsl.performanceimprovement.company.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import querydsl.performanceimprovement.company.entity.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void team을_company_name_조건으로_조회() {
        //given
        List<Team> name1 = teamRepository.findByCompanyName("name1");
        //when

        //then
    }

}