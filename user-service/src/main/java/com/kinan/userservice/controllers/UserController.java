package com.kinan.userservice.controllers;

import com.kinan.userservice.models.User;
import com.kinan.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Eren
 **/
@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @QueryMapping
    public User getUserById(@Argument String id){
        return userService.getUserById(id);
    }
    @QueryMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @MutationMapping
    public User addUser(@Argument User userInput){
        return userService.addUser(userInput);
    }
    @MutationMapping
    public Boolean deleteUserById(@Argument String id){
        return userService.deleteUserById(id);
    }
}
