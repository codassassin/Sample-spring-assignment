package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.repository.BookingRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Bookings getBookingById(long bookingId) {
        assert false;
        Query query = entityManager.createQuery("SELECT b FROM Bookings b WHERE b.id = :bookingId");
        query.setParameter("bookingId", bookingId);
        List<Bookings> bookingsList = query.getResultList();
        if(bookingsList.size() > 0) {
            return bookingsList.get(0);
        }
        return null;
    }

    public void deleteBookingsById(long bookingId) {
        Query query = entityManager.createQuery("DELETE FROM Bookings b WHERE id = :bookingId");
        query.setParameter("bookingId", bookingId);
        query.executeUpdate();
    }

    @Override
    public List<Bookings> findAll() {
        return null;
    }

    @Override
    public List<Bookings> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Bookings> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Bookings> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Bookings bookings) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Bookings> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Bookings> S save(S s) {
        return null;
    }

    @Override
    public <S extends Bookings> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Bookings> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Bookings> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Bookings> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Bookings> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Bookings getOne(Long aLong) {
        return null;
    }

    @Override
    public Bookings getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Bookings> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Bookings> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Bookings> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Bookings> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Bookings> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Bookings> boolean exists(Example<S> example) {
        return false;
    }
}
