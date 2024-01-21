package com.kinan.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eren
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {
    private String id;
    private String title;
    private Integer year;
    private String image;
    private List<String> genresIds = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();
}
