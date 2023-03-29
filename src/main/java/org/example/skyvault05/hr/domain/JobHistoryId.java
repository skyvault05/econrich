package org.example.skyvault05.hr.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobHistoryId implements Serializable {
    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employees employees;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
}
