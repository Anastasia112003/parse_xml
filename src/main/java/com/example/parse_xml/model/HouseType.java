package com.example.parse_xml.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "houseType", schema = "houseTypes")
public class HouseType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortName")
    private String shortName;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "des_c")
    private String des_c;

    @Column(name = "updateDate")
    private Date updateDate;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

}
