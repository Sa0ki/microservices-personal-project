package com.kinan.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Eren
 **/
@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;
    List<Comment> comments;
    List<Rating> ratings;
}
