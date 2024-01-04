package com.kinan.contentservice.controllers;

import com.kinan.contentservice.dtos.GenreDto;
import com.kinan.contentservice.models.Genre;
import com.kinan.contentservice.service.GenreService;
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
public class GenreController {
    private GenreService genreService;
    @MutationMapping
    public GenreDto addGenre(@Argument Genre genreInput){
        return genreService.addGenre(genreInput);
    }
}
