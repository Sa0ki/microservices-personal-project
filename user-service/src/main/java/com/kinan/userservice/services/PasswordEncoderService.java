package com.kinan.userservice.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Eren
 **/
@Service
public class PasswordEncoderService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String encorePassword(String password){
        return passwordEncoder.encode(password);
    }
}
