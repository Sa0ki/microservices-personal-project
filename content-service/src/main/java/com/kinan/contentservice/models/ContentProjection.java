package com.kinan.contentservice.models;

import com.kinan.contentservice.models.Comment;
import com.kinan.contentservice.models.Content;
import com.kinan.contentservice.models.Rating;
import org.springframework.data.rest.core.config.Projection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Projection(name = "contentProjection", types = Content.class)
public interface ContentProjection {
    String getId();
    String getTitle();
    Integer getYear();
    String getImage();
    List<String> getGenresIds();
    List<Comment> getComments();
    List<Rating> getRatings();
}
