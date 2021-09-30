package com.codassassin.tourmanagement.services.impl;


import com.fasterxml.jackson.annotation.JsonProperty;


public class SaveBookingRequest {

    @JsonProperty("bookedOn")
    private String bookedOn;

    @JsonProperty("isValid")
    private Boolean isValid;

    @JsonProperty("cancelledOn")
    private String cancelledOn;

    @JsonProperty("numberOfSeats")
    private int numberOfSeats;

    @JsonProperty("tourPackageId")
    private long tourPackageId;

    @JsonProperty("userId")
    private long userId;



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

    public long getTourPackageId() {
        return tourPackageId;
    }

    public void setTourPackageId(long tourPackageId) {
        this.tourPackageId = tourPackageId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
