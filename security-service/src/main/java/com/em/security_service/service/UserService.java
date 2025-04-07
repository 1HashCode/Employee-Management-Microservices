package com.em.security_service.service;

import com.em.security_service.model.User;
import org.springframework.stereotype.Service;
import com.em.security_service.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
