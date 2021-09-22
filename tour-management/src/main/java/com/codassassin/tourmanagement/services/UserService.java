package com.codassassin.tourmanagement.services;

import com.codassassin.tourmanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User updateTourOperator(long id, User user);
    User getUserOperator(long id, User user);
    List<User> getAllEmployees();
    void deleteUser(long id);
}
