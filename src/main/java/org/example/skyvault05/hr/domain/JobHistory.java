package org.example.skyvault05.hr.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate @DynamicInsert
@Getter @Setter
@ToString
public class JobHistory {
    @EmbeddedId
    private JobHistoryId jobHistoryId;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

}
