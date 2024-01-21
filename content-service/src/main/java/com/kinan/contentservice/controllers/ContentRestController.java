package com.kinan.contentservice.controllers;

import com.kinan.contentservice.models.Comment;
import com.kinan.contentservice.models.Content;
import com.kinan.contentservice.models.Rating;
import com.kinan.contentservice.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eren
 **/
@RestController
@AllArgsConstructor
public class ContentRestController {
    private ContentService contentService;
    @GetMapping("contents")
    public List<Content> getContents(){
        return contentService.getOriginalContents();
    }
    @PostMapping("content/add-comment/{idContent}")
    public Boolean addComment(@RequestBody Comment comment, @PathVariable String idContent){
         contentService.addCommentToContent(idContent, comment);
         return true;
    }
    @DeleteMapping("content/{contentId}/delete-comment/{commentIndex}/{idUser}")
    public Boolean deleteCommentOfContent(@PathVariable String contentId, @PathVariable int commentIndex,
                                          @PathVariable String idUser){
        return contentService.deleteCommentOfContent(contentId, commentIndex, idUser);
    }
    @PostMapping("content/add-rating/{idContent}")
    public Boolean addRating(@RequestBody Rating rating, @PathVariable String idContent){
        contentService.addRatingToContent(idContent, rating);
        return true;
    }
    @DeleteMapping("content/{contentId}/delete-rating/{ratingIndex}/{idUser}")
    public Boolean deleteRatingOfContent(@PathVariable String contentId, @PathVariable int ratingIndex,
                                          @PathVariable String idUser){
        return contentService.deleteStarsOfContent(contentId, ratingIndex, idUser);
    }
}
