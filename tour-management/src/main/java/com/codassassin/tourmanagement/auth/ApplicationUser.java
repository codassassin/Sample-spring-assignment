package com.codassassin.tourmanagement.auth;

import com.codassassin.tourmanagement.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class ApplicationUser implements UserDetails {
    private User user;

    public ApplicationUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> permissions = new ArrayList<SimpleGrantedAuthority>();
        permissions.add(new SimpleGrantedAuthority("user:read"));
        permissions.add(new SimpleGrantedAuthority("user:write"));
        return permissions;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
