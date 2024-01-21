package com.kinan.userservice.services;

import com.kinan.userservice.models.Comment;
import com.kinan.userservice.models.Content;
import com.kinan.userservice.models.Rating;
import com.kinan.userservice.repositories.IContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Eren
 **/
@Service
@AllArgsConstructor
public class ContentService {
    private IContentRepository contentRepository;
    public List<Content> getContents(){
        return contentRepository.getContents();
    }
    public Boolean addComment(Comment comment, String idContent,
                              String idUser){
        comment.setIdUser(idUser);
        return contentRepository.addComment(comment, idContent);
    }
    public Boolean deleteCommentOfContent(String idContent, int idComment, String idUser){
        return contentRepository.deleteCommentOfContent(idContent, idComment, idUser);
    }
    public Boolean addRating(Rating rating, String idContent, String idUser){
        rating.setIdUser(idUser);
        return contentRepository.addRating(rating, idContent);
    }
    public Boolean deleteRatingOfContent(String contentId, int ratingIndex,
                                         String idUser){
        return contentRepository.deleteRatingOfContent(contentId, ratingIndex, idUser);
    }
}
