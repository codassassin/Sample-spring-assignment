package com.codassassin.tourmanagement.services.impl;

import com.codassassin.tourmanagement.exception.ResourceNotFoundException;
import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.UserRepository;
import com.codassassin.tourmanagement.services.UserService;
import com.codassassin.tourmanagement.services.UserManagementService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserManagementService {

    private final UserRepository userrepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userrepository, PasswordEncoder passwordEncoder) {
        this.userrepository = userrepository;
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

        return userrepository.save(new_user);
    }

    @Override
    public User updateTourOperator(long id, User user) {
        User existingUser = userrepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUserType(user.getUserType());
        return existingUser;
    }

    @Override
    public User getUserOperator(long id, User user) {
        Optional<User> getuser = userrepository.findById(id);
        return userrepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public List<User> getAllEmployees() {
        return userrepository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        userrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userrepository.deleteById(id);
    }
}
