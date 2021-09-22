package com.codassassin.tourmanagement.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationDaoImpl {

    @Autowired
    private EntityManager entityManager;

    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        List<?> result = entityManager.createQuery("select u.user_name from tour_operator u where u.id=1").getResultList();
        System.out.println(result);
        return null;
    }
}
