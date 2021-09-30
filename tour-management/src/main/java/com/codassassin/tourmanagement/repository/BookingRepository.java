package com.codassassin.tourmanagement.repository;

import com.codassassin.tourmanagement.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
    Bookings getBookingById(long bookingId);
    void deleteBookingsById(long bookingId);
}
