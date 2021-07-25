package com.example.events.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersService extends UserDetailsService {
    boolean createUser(String username, String password, String role);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
