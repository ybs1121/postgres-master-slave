package study.postgresmasterslave.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
public class TestEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String name;


}
