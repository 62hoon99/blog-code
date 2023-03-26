package querydsl.performanceimprovement.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import querydsl.performanceimprovement.company.entity.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select t from Team t left join t.company c where t.company.name = :name")
    List<Team> findByCompanyName(@Param(value = "name") String companyName);
}
