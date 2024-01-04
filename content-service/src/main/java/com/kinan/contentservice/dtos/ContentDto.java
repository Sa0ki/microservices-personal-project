package com.kinan.contentservice.dtos;

import lombok.*;

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
    private Date releaseDate;
    private List<String> genresNames = new ArrayList<>();
    private List<String> comments = new ArrayList<>();
}
