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
@ToString
public class Regions {
    @Id
    @Column(columnDefinition = "INT UNSIGNED", length = 11, nullable = false)
    private Long regionId;

    @Column(length = 25)
    private String regionName;
}
