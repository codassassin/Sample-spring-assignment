package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.repository.TourPackageRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class TourPackageRepositoryImpl implements TourPackageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TourPackage getTourById(long tourId) {
        assert false;
        Query query = entityManager.createQuery("SELECT t FROM TourPackage t WHERE t.id=:tourId");
        query.setParameter("tourId", tourId);
        List<TourPackage> tourPackageList = query.getResultList();
        if(tourPackageList.size() > 0) {
            return tourPackageList.get(0);
        }
        return null;
    }

    public void deleteTourById(long tourId) {
        Query query = entityManager.createQuery("DELETE t FROM TourPackage t WHERE t.id=:tourId");
        query.setParameter("tourId", tourId);
        query.executeUpdate();
    }

    @Override
    public List<TourPackage> findAll() {
        return null;
    }

    @Override
    public List<TourPackage> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TourPackage> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TourPackage> findAllById(Iterable<Long> longs) {
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
    public void delete(TourPackage tourPackage) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends TourPackage> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TourPackage> S save(S s) {
        return null;
    }

    @Override
    public <S extends TourPackage> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TourPackage> findById(Long aLong) {
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
    public <S extends TourPackage> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TourPackage> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TourPackage> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TourPackage getOne(Long aLong) {
        return null;
    }

    @Override
    public TourPackage getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TourPackage> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TourPackage> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TourPackage> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TourPackage> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TourPackage> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TourPackage> boolean exists(Example<S> example) {
        return false;
    }
}
