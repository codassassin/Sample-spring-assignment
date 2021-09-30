package com.codassassin.tourmanagement.services;


import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.services.impl.SaveBookingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<Bookings> getAllBookings();
    Bookings getBooking(long id);
    Bookings saveBooking(SaveBookingRequest request);
    Bookings updateBooking(Bookings booking, long id);
    void deleteBooking(long id);
}
