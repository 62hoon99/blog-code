package querydsl.performanceimprovement.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    private Long id;

    private String name;
}
