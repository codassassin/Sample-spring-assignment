package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.Tags;
import com.codassassin.tourmanagement.repository.TagsRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class TagsRepositoryImpl implements TagsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Tags getTagsById(long tagId) {
        assert false;
        Query query = entityManager.createQuery("SELECT t FROM tags WHERE t.id = :tagId");
        query.setParameter("tagId", tagId);
        List<Tags> tagsList = query.getResultList();
        if(tagsList.size() > 0) {
            return tagsList.get(0);
        }
        return null;
    }

    public void deleteTagById(long tagId) {
        Query query = entityManager.createQuery("DELETE FROM bookings WHERE id = :tagId");
        query.setParameter("tagId", tagId);
        query.executeUpdate();
    }

    @Override
    public List<Tags> findAll() {
        return null;
    }

    @Override
    public List<Tags> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Tags> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Tags> findAllById(Iterable<Long> longs) {
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
    public void delete(Tags tags) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tags> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Tags> S save(S s) {
        return null;
    }

    @Override
    public <S extends Tags> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Tags> findById(Long aLong) {
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
    public <S extends Tags> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Tags> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Tags> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Tags getOne(Long aLong) {
        return null;
    }

    @Override
    public Tags getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Tags> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tags> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Tags> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Tags> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tags> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tags> boolean exists(Example<S> example) {
        return false;
    }
}
