package querydsl.performanceimprovement.company.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

    @Id
    private Long id;

    private String name;
}
