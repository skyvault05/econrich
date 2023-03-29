package org.example.skyvault05.hr.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@DynamicUpdate @DynamicInsert
@Getter @Setter
@ToString
public class Jobs {
    @Id
    @Column(length = 10, nullable = false)
    private String jobId;
    @Column(length = 35, nullable = false)
    private String jobTitle;
    @Column(precision=8, scale=0)
    private BigDecimal minSalary;
    @Column(precision=8, scale=0)
    private BigDecimal maxSalary;
}
