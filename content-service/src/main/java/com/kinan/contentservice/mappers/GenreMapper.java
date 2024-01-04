package com.kinan.contentservice.mappers;

import com.kinan.contentservice.dtos.GenreDto;
import com.kinan.contentservice.models.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Component
public class GenreMapper {
    private final static ModelMapper genreMapper = new ModelMapper();
    public static GenreDto fromGenreToGenreDto(Genre genre){
        return genreMapper.map(genre, GenreDto.class);
    }
    public static List<GenreDto> fromGenresToGenreDtos(List<Genre> genres){
        List<GenreDto> genreDtos = new ArrayList<>();
        genres.forEach(g -> genreDtos.add(fromGenreToGenreDto(g)));
        return genreDtos;
    }
}
