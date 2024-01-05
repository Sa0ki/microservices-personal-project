package com.kinan.contentservice.service;

import com.kinan.contentservice.controllers.ContentController;
import com.kinan.contentservice.dtos.ContentDto;
import com.kinan.contentservice.dtos.GenreDto;
import com.kinan.contentservice.mappers.ContentMapper;
import com.kinan.contentservice.mappers.GenreMapper;
import com.kinan.contentservice.models.Comment;
import com.kinan.contentservice.models.Content;
import com.kinan.contentservice.models.Genre;
import com.kinan.contentservice.models.Rating;
import com.kinan.contentservice.repositories.IContentRepository;
import com.kinan.contentservice.repositories.IGenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Service
@AllArgsConstructor
public class ContentService {
    private IContentRepository contentRepository;
    private IGenreRepository genreRepository;
    private GenreService genreService;
    public Content getContentById(String contentId){
        return contentRepository.findById(contentId).orElse(null);
    }
    public List<ContentDto> getContents(){
      List<Content> contents = contentRepository.findAll();
      List<ContentDto> contentDtos = new ArrayList<>();
      contents.forEach(c -> {
          List<Genre> genres = genreService.getGenresByIds(c.getGenresIds());
          ContentDto contentDto = ContentMapper.fromContentToContentDto(c);
          contentDto.setGenresNames(getGenresOfContentDto(genres));
          contentDtos.add(contentDto);
      });
        return contentDtos;
    }
    public List<Comment> getCommentsOfContent(String contentId){
        Content content = getContentById(contentId);
        if(content == null) return null;
        return content.getComments();
    }
    public List<GenreDto> getGenresWithContents(){
        List<Genre> genres = genreService.getGenres();
        List<Content> contents = contentRepository.findAll();
        List<GenreDto> genreDtos = new ArrayList<>();
        genres.forEach(g -> {
            GenreDto genreDto = GenreMapper.fromGenreToGenreDto(g);
            genreDto.setContents(new ArrayList<>());
            contents.forEach(c -> {
                if(g.getContentsIds() != null && g.getContentsIds().contains(c.getId())){
                    List<Genre> genresOfContent = genreService.getGenresByIds(c.getGenresIds());
                    ContentDto contentDto = ContentMapper.fromContentToContentDto(c);
                    contentDto.setGenresNames(getGenresOfContentDto(genres));
                    genreDto.getContents().add(contentDto);
                }
            });
            genreDtos.add(genreDto);
        });
        return genreDtos;
    }
    public ContentDto addContent(Content content){
        final Content savedContent = contentRepository.save(content);
        List<Genre> genres = genreService.getGenresByIds(savedContent.getGenresIds());
        genres.forEach(g -> {
            if(g.getContentsIds() == null)
                g.setContentsIds(new ArrayList<>());
            g.getContentsIds().add(savedContent.getId());
            });
        genreService.updateAllGenres(genres);
        ContentDto contentDto = ContentMapper.fromContentToContentDto(content);
        contentDto.setGenresNames(getGenresOfContentDto(genres));
        return contentDto;
    }
    public ContentDto addCommentToContent(String contentId, Comment comment){
        Content content = getContentById(contentId);
        if(content == null) return null;
        if(content.getComments() == null)
            content.setComments(new ArrayList<>());
        content.getComments().add(comment);
        contentRepository.save(content);
        List<Genre> genres = genreService.getGenresByIds(content.getGenresIds());
        ContentDto contentDto = ContentMapper.fromContentToContentDto(content);
        contentDto.setGenresNames(getGenresOfContentDto(genres));
        return contentDto;
    }
    public ContentDto addRatingToContent(String contentId, Rating rating){
        Content content = getContentById(contentId);
        if(content == null) return null;
        content.getRatings().add(rating);
        content = contentRepository.save(content);
        List<Genre> genres = genreService.getGenresByIds(content.getGenresIds());
        ContentDto contentDto = ContentMapper.fromContentToContentDto(content);
        contentDto.setGenresNames(getGenresOfContentDto(genres));
        return contentDto;
    }
    public Boolean deleteContentById(String contentId){
        Content content = getContentById(contentId);
        if(content == null) return false;
        List<Genre> genres = genreService.getGenresByIds(content.getGenresIds());
        genres.forEach(g -> g.getContentsIds().remove(contentId));
        genreService.updateAllGenres(genres);
        contentRepository.deleteById(contentId);
        return true;
    }
    public Boolean deleteGenreById(String genreId){
        Genre genre = genreService.getGenreById(genreId);
        if(genre == null) return false;
        List<Content> contents = contentRepository.findAllById(genre.getContentsIds());
        contents.forEach(c -> c.getGenresIds().remove(genreId));
        contentRepository.saveAll(contents);
        genreRepository.deleteById(genreId);
        return true;
    }
    public Boolean deleteGenreByIdFromContentOnly(String contentId, String genreId){
        Content content = getContentById(contentId);
        Genre genre = genreService.getGenreById(genreId);
        if(content == null || genre == null) return false;
        content.getGenresIds().remove(genreId);
        genre.getContentsIds().remove(content.getId());
        contentRepository.save(content);
        genreRepository.save(genre);
        return true;
    }
    public Boolean deleteCommentOfContent(String contentId, int commentIndex){
        Content content = getContentById(contentId);
        if(content == null) return false;
        if(content.getComments() == null || commentIndex < 0 || commentIndex >= content.getComments().size())
            return false;
        content.getComments().remove(commentIndex);
        contentRepository.save(content);
        return true;
    }
    public Boolean deleteStarsOfContent(String contentId, int starsIndex){
        Content content = getContentById(contentId);
        if(content == null || starsIndex < 0 || starsIndex >= content.getRatings().size())
            return false;
        content.getRatings().remove(starsIndex);
        contentRepository.save(content);
        return true;
    }
    public List<String> getGenresOfContentDto(List<Genre> genres){
        List<String> genresNames = new ArrayList<>();
        genres.forEach(g -> {
            genresNames.add(g.getName());
        });
        return genresNames;
    }
}
