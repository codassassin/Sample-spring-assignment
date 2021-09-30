package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.UserRepository;
import com.codassassin.tourmanagement.services.UserService;
import com.codassassin.tourmanagement.services.UserManagementService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService, UserManagementService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveTourOperator(User user) {
        User new_user = new User();
        new_user.setFirstName(user.getFirstName());
        new_user.setLastName(user.getLastName());
        new_user.setEmail(user.getEmail());
        new_user.setUserType(user.getUserType());
        new_user.setUsername(user.getUsername());
        new_user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(new_user);
    }

    @Override
    public User updateTourOperator(long id, User user) {
        User existingUser = userRepository.getUserById(id);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUserType(user.getUserType());
        return existingUser;
    }

    @Override
    public User getUserOperator(long id, User user) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllEmployees() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.getUserById(id);
        userRepository.deleteUserById(id);
    }
}
