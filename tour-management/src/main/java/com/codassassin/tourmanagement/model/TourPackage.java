package com.codassassin.tourmanagement.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tour_package")
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tourId;

    @Column(name = "package_name", nullable = false)
    private String packageName;

    @Column(name = "duration")
    private String duration;

    @Column(name = "price")
    private int price;
}
