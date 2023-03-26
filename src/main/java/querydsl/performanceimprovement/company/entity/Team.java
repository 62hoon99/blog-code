package querydsl.performanceimprovement.company.entity;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String name;
}
