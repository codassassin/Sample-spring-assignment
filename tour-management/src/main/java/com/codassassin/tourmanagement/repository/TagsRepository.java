package com.codassassin.tourmanagement.repository;

import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface TagsRepository extends JpaRepository<Tags, Long> {

    Tags getTagsById(long tagId);
    void deleteTagById(long tagId);
}
