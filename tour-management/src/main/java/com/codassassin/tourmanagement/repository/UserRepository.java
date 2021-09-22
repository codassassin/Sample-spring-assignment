package com.codassassin.tourmanagement.repository;

import com.codassassin.tourmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
