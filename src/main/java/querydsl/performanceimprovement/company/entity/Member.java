package querydsl.performanceimprovement.company.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Member {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private String email;

    private String name;
}
