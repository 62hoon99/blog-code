package querydsl.performanceimprovement.company.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "team")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String name;
}
