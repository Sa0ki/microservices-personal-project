package com.kinan.userservice.services;

import com.kinan.userservice.models.User;
import com.kinan.userservice.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eren
 **/
@Service
@AllArgsConstructor
public class UserService {
    private IUserRepository userRepository;
    private PasswordEncoderService passwordEncoderService;
    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User addUser(User user){
        user.setPassword(passwordEncoderService.encorePassword(user.getPassword()));
        return userRepository.save(user);
    }
    public Boolean deleteUserById(String id){
        User user = this.getUserById(id);
        if(user == null)
            return false;
        userRepository.deleteById(id);
        return true;
    }
}
