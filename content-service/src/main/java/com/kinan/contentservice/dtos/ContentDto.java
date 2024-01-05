package com.kinan.contentservice.dtos;

import com.kinan.contentservice.models.Comment;
import com.kinan.contentservice.models.Rating;
import lombok.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Eren
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {
    private String title;
    private String image;
    private Integer year;
    private List<String> genresNames = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();
}
