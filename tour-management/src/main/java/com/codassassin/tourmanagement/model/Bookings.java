package com.codassassin.tourmanagement.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "booked_on")
    private String bookedOn;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Column(name = "cancelled_on")
    private String cancelledOn;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "tour_package_id")
    private TourPackage tour_package;

    @ManyToOne
    @JoinColumn(name = "tour_operator_id")
    private User tour_operator;

    public TourPackage getTourPackage() {
        return tour_package;
    }

    public void setTourPackage(TourPackage tour_package) {
        this.tour_package = tour_package;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.tour_operator = user;
    }

    public String getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(String bookedOn) {
        this.bookedOn = bookedOn;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(String cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
