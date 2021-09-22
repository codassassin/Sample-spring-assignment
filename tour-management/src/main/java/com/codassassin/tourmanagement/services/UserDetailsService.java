package com.codassassin.tourmanagement.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {
    UserDetails loadUserByUsername(String userName);
}
