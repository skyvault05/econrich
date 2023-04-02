package org.example.skyvault05.hr.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate @DynamicInsert
@Getter @Setter
public class Countries {
    @Id
    @Column(columnDefinition = "CHAR", length = 2, nullable = false)
    private String countryId;
    @Column(length = 40)
    private String countryName;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regions;

}
