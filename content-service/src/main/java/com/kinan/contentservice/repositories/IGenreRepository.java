package com.kinan.contentservice.repositories;

import com.kinan.contentservice.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Eren
 **/
@Repository
public interface IGenreRepository extends MongoRepository<Genre, String> {
}
