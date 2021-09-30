package com.codassassin.tourmanagement.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="tour_package")
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "package_name", nullable = false)
    private String packageName;

    @Column(name = "duration")
    private String duration;

    @Column(name = "start_date")
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

//    public Set<Bookings> getBooking() {
//        return booking;
//    }
//
//    public void setBooking(Set<Bookings> booking) {
//        this.booking = booking;
//    }

    @Column(name = "price")
    private int price;

    @Column(name = "seats")
    private int seats;

//    @OneToMany(mappedBy="tour_package")
//    private Set<Bookings> booking;

    @Override
    public String toString() {
        return " " + id;
    }

}
