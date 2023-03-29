package org.example.skyvault05.hr.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate @DynamicInsert
@Getter @Setter
@ToString
public class Employees {
    @Id
    @Column(columnDefinition = "INT UNSIGNED", length = 11, nullable = false)
    private Long employeeId;
    @Column(length = 20)
    private String firstName;
    @Column(length = 25, nullable = false)
    private String lastName;
    @Column(length = 25, nullable = false)
    private String email;
    @Column(length = 20)
    private String phoneNumber;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;
    @Column(precision = 8, scale = 2)
    private BigDecimal salary;
    @Column(precision = 2, scale = 2)
    private BigDecimal commissionPct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;


}
