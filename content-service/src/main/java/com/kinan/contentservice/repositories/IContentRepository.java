package com.kinan.contentservice.repositories;

import com.kinan.contentservice.models.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eren
 **/
@Repository
public interface IContentRepository extends MongoRepository<Content, String> {
}
