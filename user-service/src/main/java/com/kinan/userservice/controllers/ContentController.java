package com.kinan.userservice.controllers;

import com.kinan.userservice.models.Comment;
import com.kinan.userservice.models.Content;
import com.kinan.userservice.models.Rating;
import com.kinan.userservice.services.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eren
 **/
@Controller
@EnableFeignClients
@AllArgsConstructor
public class ContentController {
    private final ContentService contentService;
    @QueryMapping
    public List<Content> getContents(){
        return contentService.getContents();
    }
    @MutationMapping
    public Boolean addComment(@Argument Comment comment, @Argument String idContent,
                              @Argument String idUser){
        return contentService.addComment(comment, idContent, idUser);
    }
    @MutationMapping
    Boolean addRating(@Argument Rating rating, @Argument String idContent,
                      @Argument String idUser){
        return contentService.addRating(rating, idContent, idUser);
    }
    @MutationMapping
    public Boolean deleteComment(@Argument String idContent, @Argument int indexComment,
                                 @Argument String idUser){
        return contentService.deleteCommentOfContent(idContent, indexComment, idUser);
    }
    @MutationMapping
    public Boolean deleteRating(@Argument String idContent, @Argument int indexRating,
                                         @Argument String idUser){
        return contentService.deleteRatingOfContent(idContent, indexRating, idUser);
    }
}
