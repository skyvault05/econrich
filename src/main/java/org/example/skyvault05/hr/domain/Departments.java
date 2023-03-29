package org.example.skyvault05.hr.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate @DynamicInsert
@Getter @Setter
public class Departments {
    @Id
    @Column(columnDefinition = "INT UNSIGNED", length = 11, nullable = false)
    private Long departmentId;
    @Column(length = 30)
    private String departmentName;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;
}
