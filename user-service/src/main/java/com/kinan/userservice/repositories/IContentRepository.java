package com.kinan.userservice.repositories;

import com.kinan.userservice.models.Comment;
import com.kinan.userservice.models.Content;
import com.kinan.userservice.models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Eren
 **/
@FeignClient(name = "CONTENT-SERVICE")
public interface IContentRepository {
    @GetMapping("contents")
    List<Content> getContents();
    @PostMapping("content/add-comment/{idContent}")
    Boolean addComment(@RequestBody Comment comment, @PathVariable String idContent);
    @DeleteMapping("content/{contentId}/delete-comment/{commentIndex}/{idUser}")
    Boolean deleteCommentOfContent(@PathVariable String contentId, @PathVariable int commentIndex,
                                          @PathVariable String idUser);
    @PostMapping("content/add-rating/{idContent}")
    Boolean addRating(@RequestBody Rating rating, @PathVariable String idContent);
    @DeleteMapping("content/{contentId}/delete-rating/{ratingIndex}/{idUser}")
    public Boolean deleteRatingOfContent(@PathVariable String contentId, @PathVariable int ratingIndex,
                                         @PathVariable String idUser);
}
