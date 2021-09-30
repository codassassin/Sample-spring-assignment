package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.BookingRepository;
import com.codassassin.tourmanagement.repository.TourPackageRepository;
import com.codassassin.tourmanagement.repository.UserRepository;
import com.codassassin.tourmanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Bookings getBooking(long id) {
        return bookingRepository.getBookingById(id);
    }

    @Override
    public Bookings saveBooking(SaveBookingRequest request) {
        long userId = request.getUserId();
        long tourId = request.getTourPackageId();


        Bookings booking = new Bookings();
        User user = userRepository.getUserById(userId);
        TourPackage tourPackage = tourPackageRepository.getTourById(tourId);

        tourPackage.setSeats(tourPackage.getSeats() - request.getNumberOfSeats());

        booking.setUser(user);
        booking.setTourPackage(tourPackage);
        return bookingRepository.save(booking);
    }

    //userId = request.getUserId();
    //tourId = request.getTourId();
    //Bookings booking = new Bookings();
    //User user = userRepository.findById(userId).orElseThrow(
    //                () -> new ResourceNotFoundException("User", "id", userId)
    //        );
    //TourPackage tourPackage = tourPackageRepository.findById(tourId).orElseThrow(
    //                () -> new ResourceNotFoundException("TourPackage", "id", tourId)
    //        );
    //booking.setUser(user);
    //booking.setTourPackage(tourPackage);
    //entityManager.persist(booking);
    //return booking;

    @Override
    public Bookings updateBooking(Bookings booking, long id) {
        Bookings existingBooking = bookingRepository.getBookingById(id);

        existingBooking.setBookedOn(booking.getBookedOn());
        existingBooking.setCancelledOn(booking.getCancelledOn());
        existingBooking.setIsValid(booking.getIsValid());
        bookingRepository.save(existingBooking);
        return existingBooking;
    }

    @Override
    public void deleteBooking(long id) {
        bookingRepository.getBookingById(id);
        bookingRepository.deleteBookingsById(id);
    }
}
