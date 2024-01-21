package com.kinan.contentservice.repositories;

import com.kinan.contentservice.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * @author Eren
 **/
@RepositoryRestResource
public interface IGenreRepository extends MongoRepository<Genre, String> {
}
