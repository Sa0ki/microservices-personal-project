package com.kinan.userservice.repositories;

import com.kinan.userservice.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eren
 **/
@Repository
public interface IUserRepository extends MongoRepository<User, String> {
}
