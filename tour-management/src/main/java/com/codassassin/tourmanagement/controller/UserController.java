package com.codassassin.tourmanagement.controller;


import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    // build update tour-operator REST API
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<User> updateUserOperator(@PathVariable("id") long id, @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateTourOperator(id, user), HttpStatus.OK);
    }

    // build get tour-operator REST API
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<User> getUserOperator(@PathVariable("id") long id, @RequestBody User user) {
        return new ResponseEntity<User>(userService.getUserOperator(id, user), HttpStatus.OK);
    }

    // build get user REST API
    @GetMapping
    @RolesAllowed("OPERATOR")
    public List<User> getAllEmployees() {
        return userService.getAllEmployees();
    }

    // build delete user REST API
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {

        // delete from DB
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
