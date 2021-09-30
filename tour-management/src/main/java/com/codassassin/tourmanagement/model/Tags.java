package com.codassassin.tourmanagement.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "tour_package_tags",
            joinColumns =
                    { @JoinColumn(name = "tag_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "tour_package_id", referencedColumnName = "id") })
    private TourPackage tourPackage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
