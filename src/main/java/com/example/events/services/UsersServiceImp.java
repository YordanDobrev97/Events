package com.example.events.services;

import com.example.events.interfaces.UsersService;
import com.example.events.models.User;
import com.example.events.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UsersService {
    private UserRepository userRepository;

    public UsersServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        this.userRepository.save(user);
        return true;
    }
}
