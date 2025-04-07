package com.em.security_service.service;

import com.em.security_service.DTO.LoginRequestDTO;
import com.em.security_service.jwt.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtTokenUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtTokenUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        return userService.findByEmail(loginRequestDTO.getEmail())
                .filter(user->passwordEncoder.matches(loginRequestDTO.getPassword(),user.getPassword()))
                .map(user -> jwtTokenUtil.generateToken(user.getPassword(),user.getRole()));


    }

    public boolean validateToken(String token) {
        try{
            jwtTokenUtil.validateToken(token);
            return true;
        }
        catch (JwtException e){
            return false;
        }
    }
}
