package com.kinan.contentservice.controllers;

import com.kinan.contentservice.dtos.ContentDto;
import com.kinan.contentservice.dtos.GenreDto;
import com.kinan.contentservice.models.Content;
import com.kinan.contentservice.models.Genre;
import com.kinan.contentservice.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Eren
 **/
@Controller
@AllArgsConstructor
public class ContentController {
    private ContentService contentService;
    @QueryMapping
    public List<ContentDto> getContents(){
        return contentService.getContents();
    }
    @QueryMapping
    public List<String> getCommentsOfContent(@Argument String contentId){
        return contentService.getCommentsOfContent(contentId);
    }
    @QueryMapping
    public List<GenreDto> getGenresWithContents(){
        return contentService.getGenresWithContents();
    }
    @MutationMapping
    public ContentDto addContent(@Argument Content contentInput){
        return contentService.addContent(contentInput);
    }
    @MutationMapping
    public ContentDto addCommentToContent(@Argument String contentId, @Argument String comment){
        return contentService.addCommentToContent(contentId, comment);
    }
    @MutationMapping
    public ContentDto addStarsToContent(@Argument String contentId, @Argument Double stars){
        return contentService.addStarsToContent(contentId, stars);
    }
    @MutationMapping
    public Boolean deleteContentById(@Argument String contentId){
        return contentService.deleteContentById(contentId);
    }
    @MutationMapping
    public Boolean deleteGenreById(@Argument String genreId){
        return contentService.deleteGenreById(genreId);
    }
    @MutationMapping
    public Boolean deleteGenreByIdFromContentOnly(@Argument String contentId, @Argument String genreId){
        return contentService.deleteGenreByIdFromContentOnly(contentId, genreId);
    }
    @MutationMapping
    public Boolean deleteCommentOfContent(@Argument String contentId, @Argument int commentIndex){
        return contentService.deleteCommentOfContent(contentId, commentIndex);
    }
    @MutationMapping
    public Boolean deleteStarsOfContent(@Argument String contentId, @Argument int starsIndex){
        return contentService.deleteStarsOfContent(contentId, starsIndex);
    }
}
