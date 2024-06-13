package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.OurUsers;
import com.phegondev.usersmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<OurUsers> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<OurUsers> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public OurUsers createUser(OurUsers user) {
        return userRepository.save(user);
    }

    public OurUsers updateUser(Integer userId, OurUsers userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
