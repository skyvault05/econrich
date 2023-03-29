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
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED", length = 11, nullable = false)
    private Long locationId;
    @Column(length = 40)
    private String streetAddress;
    @Column(length = 12)
    private String postalCode;
    @Column(length = 30, nullable = false)
    private String city;
    @Column(length = 25)
    private String stateProvince;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;
}
