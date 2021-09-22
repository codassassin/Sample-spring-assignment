package com.codassassin.tourmanagement.controller;

import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.services.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register-user")
public class UserManagementController {
    private UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    // build create tour-operator REST API
    @PostMapping
    public ResponseEntity<User> saveUserOperator(@RequestBody User userOperator) {
        return new ResponseEntity<User>(userManagementService.saveTourOperator(userOperator), HttpStatus.CREATED);
    }
}
