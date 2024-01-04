package com.kinan.contentservice.service;

import com.kinan.contentservice.dtos.GenreDto;
import com.kinan.contentservice.mappers.GenreMapper;
import com.kinan.contentservice.models.Content;
import com.kinan.contentservice.models.Genre;
import com.kinan.contentservice.repositories.IGenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eren
 **/
@Service
@AllArgsConstructor
public class GenreService {
    private IGenreRepository genreRepository;
    public Genre getGenreById(String genreId){
        return genreRepository.findById(genreId).orElse(null);
    }
    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }
    public GenreDto addGenre(Genre genre){
        return GenreMapper.fromGenreToGenreDto(genreRepository.save(genre));
    }
    public List<Genre> getGenresByIds(List<String> genresIds){
        return genreRepository.findAllById(genresIds);
    }
    public void updateAllGenres(List<Genre> genres){
        genreRepository.saveAll(genres);
    }
}
