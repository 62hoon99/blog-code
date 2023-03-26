package querydsl.performanceimprovement.company.entity;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Team team;

    private String email;

    private String name;
}
