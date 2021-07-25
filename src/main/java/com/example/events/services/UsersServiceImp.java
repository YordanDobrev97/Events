package com.example.events.services;

import com.example.events.interfaces.UsersService;
import com.example.events.models.User;
import com.example.events.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UsersService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersServiceImp(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean createUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        String hashPassword = this.bCryptPasswordEncoder.encode(password);
        user.setPassword(hashPassword);
        user.setRole(role);

        this.userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
