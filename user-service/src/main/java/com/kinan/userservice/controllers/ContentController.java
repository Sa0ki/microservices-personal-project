package com.kinan.userservice.controllers;

import com.kinan.userservice.models.Comment;
import com.kinan.userservice.models.Content;
import com.kinan.userservice.models.Rating;
import com.kinan.userservice.repositories.IContentRepository;
import com.kinan.userservice.services.ContentService;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eren
 **/
@RestController
@EnableFeignClients
@AllArgsConstructor
public class ContentController {
    private final ContentService contentService;
    @GetMapping("contents")
    public List<Content> getContents(){
        return contentService.getContents();
    }
    @PostMapping("content/add-comment/{idContent}/{idUser}")
    public Boolean addComment(@RequestBody Comment comment, @PathVariable String idContent,
                              @PathVariable String idUser){
        return contentService.addComment(comment, idContent, idUser);
    }
    @DeleteMapping("content/{contentId}/delete-comment/{commentIndex}/{idUser}")
    public Boolean deleteComment(@PathVariable String contentId, @PathVariable int commentIndex,
                                 @PathVariable String idUser){
        return contentService.deleteCommentOfContent(contentId, commentIndex, idUser);
    }
    @PostMapping("content/add-rating/{idContent}/{idUser}")
    Boolean addRating(@RequestBody Rating rating, @PathVariable String idContent,
                      @PathVariable String idUser){
        return contentService.addRating(rating, idContent, idUser);
    }
    @DeleteMapping("content/{contentId}/delete-rating/{ratingIndex}/{idUser}")
    public Boolean deleteRatingOfContent(@PathVariable String contentId, @PathVariable int ratingIndex,
                                         @PathVariable String idUser){
        return contentService.deleteRatingOfContent(contentId, ratingIndex, idUser);
    }
}
