package com.example.journal.Service;

import com.example.journal.Entity.User;
import com.example.journal.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean checkLogin(String username, String password) {
        Optional<User> user = repo.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
