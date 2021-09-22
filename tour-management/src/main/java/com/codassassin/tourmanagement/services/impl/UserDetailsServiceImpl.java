package com.codassassin.tourmanagement.services.impl;

import com.codassassin.tourmanagement.auth.ApplicationUser;
import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.UserRepository;
import com.codassassin.tourmanagement.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new ApplicationUser(user);
    }
}
