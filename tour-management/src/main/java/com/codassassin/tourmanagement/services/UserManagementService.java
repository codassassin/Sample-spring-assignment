package com.codassassin.tourmanagement.services;

import com.codassassin.tourmanagement.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserManagementService {
    User saveTourOperator(User user);
}
