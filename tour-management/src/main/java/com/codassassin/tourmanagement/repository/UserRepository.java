package com.codassassin.tourmanagement.repository;

import com.codassassin.tourmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
    User getUserById(long userId);
    void deleteUserById(long userId);
}
