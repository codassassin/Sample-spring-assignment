package com.codassassin.tourmanagement.controller;

import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.services.BookingService;
import com.codassassin.tourmanagement.services.impl.SaveBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingsController {

    @Autowired
    private BookingService bookingService;

    // build get all package REST API
    @GetMapping
    @RolesAllowed({"OPERATOR"})
    public List<Bookings> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<Bookings> getBooking(@PathVariable("id") long id) {
        return new ResponseEntity<Bookings>(bookingService.getBooking(id), HttpStatus.OK);
    }

    // build create tour package REST API
    @PostMapping()
    @RolesAllowed({"REGISTERED_USER"})
    public ResponseEntity<Bookings> saveBooking(@RequestBody SaveBookingRequest request) {
        return new ResponseEntity<Bookings>(bookingService.saveBooking(request), HttpStatus.CREATED);
    }

    //saveBooking(@RequestBody SaveBookingRequest request)

    // build edit tour package REST API
    @PutMapping("/{id}")
    @RolesAllowed({"OPERATOR", "REGISTERED_USER"})
    public ResponseEntity<Bookings> updateBooking(@PathVariable("id") long id,
                                                         @RequestBody Bookings booking) {
        return new ResponseEntity<Bookings>(bookingService.updateBooking(booking, id), HttpStatus.OK);
    }

    // build delete tour package REST API
    @DeleteMapping("/{id}")
    @RolesAllowed({"OPERATOR", "REGISTERED_USER"})
    public ResponseEntity<String> deleteBooking(@PathVariable("id") long id) {

        // delete from DB
        bookingService.deleteBooking(id);
        return new ResponseEntity<String>("Booking deleted successfully", HttpStatus.OK);
    }
}
